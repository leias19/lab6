package errors;

public class UnknownElementException extends Exception {
    /**
     *  Конструктор для исключения UnknownElementException
     */
    public UnknownElementException() {
        super("Неизвестный элемент");
    }

    /**
     *  Конструктор для исключения UnknownElementException
     * @param key ключ
     */

    public UnknownElementException(String key) {
        super("неизвестный элемент с ключом " + key);
    }
}
