package system;

import data.HumanBeing;
import data.generators.HumanBeingGenerator;
import manager.ExecuteScript;
import java.io.InputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Console {
    private Request request;

    private static String filename;

    public void setFilename(String filename){
        this.filename = filename;
    }

    /**
     *  Метод для запуска
     * @param inputStream входной поток
     * @throws Exception исключение
     */
    public void start(InputStream inputStream) throws Exception {
        while (true) {
            Scanner scanner = new Scanner(inputStream);
            try {
                String[] elements = scanner.nextLine().split(" ");
                String input = elements[0];
                Client client = new Client();

                if (input.equals("insert") || input.equals("update_id") || input.equals("replace_if_greater")) {
                    if (elements.length == 1) {
                        System.out.println("введите аргумент после команды");
                    } else {
                        request = new Request(input, null, null);
                        String key = elements[1];
                        if (input.equals("update_id")) {
                            HumanBeing humanBeing = HumanBeingGenerator.createHumanBeing(Integer.parseInt(key));
                            request.setHumanBeing(humanBeing);
                        }else{
                            HumanBeing humanBeing = HumanBeingGenerator.createHumanBeing(0);
                            request.setHumanBeing(humanBeing);
                        }
                        request.setKey(key);
                        String echo = client.sendEcho(request);
                        System.out.println("Ответ сервера: \n" + echo);
                        client.close();

                    }
                }else if (input.equals("remove_any_by_mood") || input.equals("count_less_than_weapon_type") || input.equals("remove_greater_key") || input.equals("remove_lower_key")) {
                    if (elements.length == 1) {
                        System.out.println("введите аргумент после команды");
                    } else {
                        request = new Request(input, null, null);
                        String key = elements[1];
                        request.setKey(key);
                        String echo = client.sendEcho(request);
                        System.out.println("Ответ сервера: \n" + echo);
                        client.close();
                    }
                }else if (input.equals("exit")) {
                    request = new Request(input);
                    System.out.println("пока пока");
                    System.exit(1);
                } else if (input.split(" ")[0].equals("execute_script")) {
                    request = new Request(input, null, null);
                    request.setKey(elements[1]);
                    ExecuteScript.execute(request);
                } else {
                    request = new Request(input);
                    String echo = client.sendEcho(request);
                    System.out.println("Ответ сервера: \n" + echo);
                    client.close();
                }

            } catch(SocketException e){
                System.out.println("SocketException: \n" + e.getMessage());
            } catch(UnknownHostException e){
                System.out.println("UnknownHostException: \n" + e.getMessage());
            }
        }

    }

}
