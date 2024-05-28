package managers;

import commands.*;
import errors.IncorrectInputException;
import errors.UnknownCommandException;
import errors.UnknownElementException;
import system.Request;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandManager {
    private static Map<String, Command> commandList;

    private static Request request = new Request(null, null, null);

    /**
     * Конструктор для CommandManager
     */
    public CommandManager() {
        commandList = new HashMap<>();
        commandList.put("help", new Help());
        commandList.put("info", new Info());
        commandList.put("show", new Show());
        commandList.put("insert", new Insert());
        commandList.put("update_id", new UpdateId());
        commandList.put("remove_key", new RemoveKey());
        commandList.put("clear", new Clear());
        commandList.put("replace_if_greater", new ReplaceIfGreater());
        commandList.put("remove_greater_key", new RemoveGreaterKey());
        commandList.put("remove_lower_key", new RemoveLowerKey());
        commandList.put("remove_any_by_mood", new RemoveAnyByMood());
        commandList.put("max_by_id", new MaxById());
        commandList.put("count_less_than_weapon_type", new CountLessThanWeaponType());
    }

    /**
     *  Метод для выполнения команды
     * @param request запрос
     * @return результат
     * @throws Exception исключение
     */
    public static String startExecuting(Request request) throws Exception {
        String[] elements = request.getMessage().split(" ");
        String commandName = elements[0];
        if (!commandList.containsKey(commandName)) {
            return "неизвестная команда";
        }
        Command command = commandList.get(commandName);
        return command.execute(request);
    }

    /**
     *  Метод для получения списка команд
     * @return список команд
     */
    public static Map<String, Command> getCommandList() {
        return commandList;
    }
}
