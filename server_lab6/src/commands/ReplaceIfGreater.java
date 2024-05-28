package commands;

import data.HumanBeing;
import data.comporators.HumanBeingComparator;
import data.generators.HumanBeingGenerator;
import errors.IncorrectInputException;
import errors.UnknownElementException;
import managers.CollectionManager;
import system.Request;

import java.util.TreeMap;


public class ReplaceIfGreater implements Command {
    /**
     *  Метод для выполнения команды replace_if_greater
     * @param request аргумент
     */
    @Override
    public String execute(Request request) throws UnknownElementException, IncorrectInputException {
        StringBuilder line = new StringBuilder();
        String key = request.getKey();
        HumanBeing humanToReplace = request.getHumanBeing();
        TreeMap<String, HumanBeing> map = CollectionManager.getMap();
        HumanBeingComparator h1 = new HumanBeingComparator();
        if (map.containsKey(key)) {
            if (h1.compare(humanToReplace, map.get(key)) > 0) {
                humanToReplace.setId(map.get(key).getId());
                CollectionManager.remove(key);
                CollectionManager.add(key, humanToReplace);
                line.append("замена выполнена");
            }else {
                line.append("элемент не был заменен");
            }
        }else{
            line.append("элемент с таким ключом отсутствует");
        }
        return line.toString();
    }

    /**
     *  Метод для получения имени команды replace_if_greater
     * @return имя
     */

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    /**
     *  Метод для получения описания команды replace_if_greater
     * @return описание
     */

    @Override
    public String getDescription() {
        return "заменить значение по ключу, если новое значение больше старого";
    }
}
