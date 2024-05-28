package system;

import managers.CommandManager;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    private DatagramSocket socket;
    private InetAddress address;
    int port;
    private byte[] buffer = new byte[5000]; // Буфер для хранения входящих данных

    /**
     *  Конструктор
     * @param port порт
     * @throws SocketException исключение
     */
    public Server(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    /**
     *  Метод для прослушивания
     * @throws Exception исключение
     */
    public void listen() throws Exception {
        while (true) {
            Request request = getRequest();
            String commandName = request.getMessage().split(" ")[0];
            // обработка полученного запроса
            String message = CommandManager.startExecuting(request);
            request.setMessage(message);


            // Отправка ответа
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(request);
            objectOutputStream.close();
            DatagramPacket sendPacket = new DatagramPacket(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.toByteArray().length, address, port);

            socket.send(sendPacket);
            System.out.println("команда " + commandName + " выполнена");

        }
    }

    /**
     *  Метод для получения запроса
     * @return запрос
     * @throws IOException ошибка системы
     * @throws ClassNotFoundException ошибка сериализации
     */
    public Request getRequest() throws IOException, ClassNotFoundException {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet); // Получение пакета от клиента

        address = packet.getAddress();
        port = packet.getPort();

        // Извлечение данных из пакета
        Request request;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packet.getData());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        request = (Request) objectInputStream.readObject();
        objectInputStream.close();

        return request;
    }


    /**
     *  Метод для закрытия сокета
     */
    public void close() {
        socket.close();
    }
}
