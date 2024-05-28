package commands;

import errors.UnknownElementException;
import managers.CollectionManager;
import system.Request;

public class RemoveKey implements Command {
    /**
     *  Метод для выполнения команды remove_key
     * @param request аргумент
     * @throws UnknownElementException ошибка при отсутствии элемента
     */
    @Override
    public String execute(Request request) throws UnknownElementException {
        StringBuilder line = new StringBuilder();
        String key = request.getKey();
        CollectionManager.remove(key);
        line.append("удаление выполнено");
        return line.toString();
    }

    /**
     *  Метод для получения имени команды remove_key
     * @return имя
     */

    @Override
    public String getName() {
        return "remove_key";
    }

    /**
     *  Метод для получения описания команды remove_key
     * @return  описание
     */

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его ключу";
    }
}
