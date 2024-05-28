package commands;

import data.HumanBeing;
import managers.CollectionManager;
import system.Request;

import java.util.TreeMap;

public class RemoveLowerKey implements Command {
    /**
     *  Метод для выполнения команды remove_lower_key
     * @param request аргумент
     */
    @Override
    public String execute(Request request)  {
        StringBuilder line = new StringBuilder();
        String lowerKey = request.getKey();
        var result = CollectionManager.getMap().entrySet()
                .removeIf(entry -> Integer.parseInt(entry.getKey()) > Integer.parseInt(lowerKey));
        if (result) {
            line.append("удаление выполнено");
        } else {
            line.append("элементы с превышенным ключом не найдены");
        }
        return line.toString();
    }

    /**
     *  Метод для получения имени команды remove_lower_key
     * @return имя
     */

    @Override
    public String getName() {
        return "remove_lower_key";
    }

    /**
     *  Метод для получения описания команды remove_lower_key
     * @return описание
     */

    @Override
    public String getDescription() {
        return "удалить из  коллекции все элементы ключ которых меньше, чем заданный";
    }
}
