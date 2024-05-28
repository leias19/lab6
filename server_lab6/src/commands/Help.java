package commands;

import managers.CollectionManager;
import managers.CommandManager;
import system.Request;

import java.util.Map;

public class Help implements Command {
    /**
     *  Метод для выполнения команды help
     * @param request аргумент
     */
    @Override
    public String execute(Request request)  {
        StringBuilder line = new StringBuilder();
        Map<String, Command> commandList = CommandManager.getCommandList();
        commandList.forEach((name, command) -> line.append(command.getName()).append(" - ").append(command.getDescription()).append("\n"));
        line.append("execute_script").append(" - ").append("считать и исполнить скрипт из указанного файла");
        return line.toString();
    }

    /**
     *  Метод для получения имени команды help
     * @return имя
     */

    @Override
    public String getName() {
        return "help";
    }

    /**
     *  Метод для получения описания команды help
     * @return описание
     */

    @Override
    public String getDescription() {
        return "вывести справку по доступным командам";
    }
}