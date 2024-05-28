package commands;

import managers.CollectionManager;
import system.Request;

public class Clear implements Command{
    /**
     *  Метод для выполнения команды clear
     * @param request аргумент
     */
    @Override
    public String execute(Request request)  {
        CollectionManager.clear();
        return "коллекция очищена";
    }

    /**
     *  Метод для получения имени команды clear
     * @return имя
     */

    @Override
    public String getName() {
        return "clear";
    }

    /**
     *  Метод для получения описания команды clear
     * @return описание
     */

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }
}
