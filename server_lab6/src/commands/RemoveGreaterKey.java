package commands;

import data.HumanBeing;
import managers.CollectionManager;
import system.Request;

import java.io.StringReader;
import java.util.TreeMap;

public class RemoveGreaterKey implements Command {
    /**
     *  Метод для выполнения команды remove_greater_key
     * @param request аргумент
     */
    @Override
    public String execute(Request request)  {
        StringBuilder line = new StringBuilder();
        String greaterKey = request.getKey();
        var result = CollectionManager.getMap().entrySet()
                .removeIf(entry -> Integer.parseInt(entry.getKey()) < Integer.parseInt(greaterKey));
        if (result) {
            line.append("удаление выполнено");
        } else {
            line.append("элементы с превышенным ключом не найдены");
        }
        return line.toString();
    }

    /**
     *  Метод для получения имени команды remove_greater_key
     * @return имя
     */

    @Override
    public String getName() {
        return "remove_greater_key";
    }

    /**
     *  Метод для получения описания команды remove_greater_key
     * @return описание
     */

    @Override
    public String getDescription() {
        return "удалить из  коллекции все элементы ключ которых превышает заданный";
    }
}
