package commands;


import data.HumanBeing;
import managers.CollectionManager;
import managers.FileManager;
import system.Request;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Save implements Command {
    /**
     *  Метод для выполнения команды save
     * @param request аргумент
     */
    @Override
    public String execute(Request request)  {
        StringBuilder line = new StringBuilder();
        Map<String, HumanBeing> map = CollectionManager.getMap();
        FileManager.writeFile(map);
        line.append("коллекция сохранена");
        return line.toString();
    }

    /**
     *  Метод для получения имени команды save
     * @return имя
     */

    @Override
    public String getName() {
        return "save";
    }

    /**
     *  Метод для получения описания команды save
     * @return описание
     */

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }
}
