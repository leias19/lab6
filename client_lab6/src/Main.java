import system.Console;

public class Main {
    /**
     *  Метод main
     * @param args - аргумент
     * @throws Exception - исключение
     */
    public static void main(String[] args) throws Exception {
        Console console = new Console();
        System.out.println("Введите команду 'help', чтобы увидеть все доступные команды");
        console.start(System.in);
    }
}

