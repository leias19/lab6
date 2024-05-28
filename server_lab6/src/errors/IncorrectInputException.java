package errors;

public class IncorrectInputException extends Exception {
    /**
     *  Конструктор для исключения IncorrectInputException
     * @param data неправильный аргумент
     */
    public IncorrectInputException(String data){

        super("Неправильный аргумент ввода: " + data);
    }
}