package commands;

import data.HumanBeing;
import data.generators.HumanBeingGenerator;
import errors.IncorrectInputException;
import errors.UnknownElementException;
import managers.CollectionManager;
import system.Request;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;


public class UpdateId implements Command {
    /**
     *  Метод для выполнения команды update_id
     * @param request аргумент
     */
    @Override
    public String execute(Request request) {
        StringBuilder line = new StringBuilder();
        try {
            int counter = 0;
            int id = Integer.parseInt(request.getKey());
            HumanBeing newHuman = request.getHumanBeing();
            for (Map.Entry<String, HumanBeing> humans : CollectionManager.getMap().entrySet()) {
                if (humans.getValue().getId() == id) {
                    CollectionManager.remove(humans.getKey());
                    CollectionManager.add(humans.getKey(), newHuman);
                    line.append("элемент был обновлен");
                } else {
                    counter++;
                }
            }
            if (counter == CollectionManager.getMap().size()) {
                line.append("элемент с таким id отсутствует");
            }

        } catch (UnknownElementException e) {
            line.append(e.getMessage());
        }
            return line.toString();
    }

        /**
     *  Метод для получения имени команды update_id
     * @return имя
     */

    @Override
    public String getName() {
        return "update_id";
    }

    /**
     *  Метод для получения описания команды update_id
     * @return описание
     */

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}
