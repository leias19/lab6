package commands;

import data.HumanBeing;
import data.generators.HumanBeingGenerator;
import data.generators.IdGenerator;
import errors.IncorrectInputException;
import managers.CollectionManager;
import system.Request;

public class Insert implements Command {
    /**
     *  Метод для выполнения команды insert
     * @param request аргумент
     */

    @Override
    public String execute(Request request) {
        StringBuilder line = new StringBuilder();
        HumanBeing humanBeing = request.getHumanBeing();
        String key = request.getKey();
        CollectionManager.add(key, humanBeing);
        line.append("добавление выполнено");
        return line.toString();
    }

    /**
     *  Метод для получения имени команды insert
     * @return имя
     */

    @Override
    public String getName() {
        return "insert";
    }

    /**
     *  Метод для получения описания команды insert
     * @return описание
     */

    @Override
    public String getDescription() {
        return "добавить новый элемент с заданным ключом";
    }
}
