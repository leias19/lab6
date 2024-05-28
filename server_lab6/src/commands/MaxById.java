package commands;

import data.HumanBeing;
import managers.CollectionManager;
import system.Request;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class MaxById implements Command {
    /**
     *  Метод для выполнения команды max_by_id
     * @param request аргумент
     */
    @Override
    public String execute(Request request) {
        StringBuilder line = new StringBuilder();
        line.append(CollectionManager.getMap().values().stream()
                .max(HumanBeing::compareTo).map(HumanBeing::toString).orElse("коллекция пуста"));
        return line.toString();
    }

    /**
     *  Метод для получения имени команды max_by_id
     * @return имя
     */

    @Override
    public String getName() {
        return "max_by_id";
    }

    /**
     *  Метод для получения описания команды max_by_id
     * @return описание
     */

    @Override
    public String getDescription() {
        return "вывести любой объект из коллекции, значение поля id которого является максимальным";
    }
}
