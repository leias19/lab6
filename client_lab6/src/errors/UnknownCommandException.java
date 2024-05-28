package errors;

public class UnknownCommandException extends Exception{
    /**
     *  Конструктор для исключения UnknownCommandException
     * @param commandName неправильная команда
     */
    public UnknownCommandException(String commandName) {
        super("Неизвестная команда: " + commandName);
    }
}