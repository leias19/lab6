package commands;

import errors.IncorrectInputException;
import errors.UnknownElementException;
import system.Request;

import java.io.FileNotFoundException;

public interface Command {
    /**
     *  Метод для выполнения команды
     * @param request аргумент
     * @throws FileNotFoundException Исключение при некорректном вводе
     * @throws UnknownElementException Исключение при некорректном вводе
     */
    String execute(Request request) throws FileNotFoundException, UnknownElementException, IncorrectInputException;

    /**
     *  Метод для получения имени команды
     * @return имя
     */
    String getName();

    /**
     *  Метод для получения описания
     * @return описание
     */
    String getDescription();
}