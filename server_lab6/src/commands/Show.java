package commands;

import data.HumanBeing;
import managers.CollectionManager;
import system.Request;

import java.util.TreeMap;

public class Show implements Command {
    /**
     *  Метод для выполнения команды show
     * @param request аргумент
     */
    @Override
    public String execute(Request request)  {
        StringBuilder line = new StringBuilder();
        TreeMap<String, HumanBeing> map = CollectionManager.getMap();
        if (map.isEmpty()) {
            line.append(CollectionManager.getMap().getClass().getName()).append(" is empty");
        } else{
            map.forEach((key, human) -> line.append(human).append("\n"));
        }
        return line.toString();
    }

    /**
     *  Метод для получения имени команды show
     * @return имя
     */

    @Override
    public String getName() {
        return "show";
    }

    /**
     *  Метод для получения описания команды show
     * @return описание
     */

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
