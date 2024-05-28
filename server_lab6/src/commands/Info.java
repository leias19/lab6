package commands;

import managers.CollectionManager;
import system.Request;

public class Info implements Command{
    /**
     *  Метод для выполнения команды info
     * @param request аргумент
     */
    @Override
    public String execute(Request request) {
        StringBuilder line = new StringBuilder();
        line.append("Data type - ").append(CollectionManager.getMap().getClass().getName()).append("\n");
        line.append("Count of persons - ").append(CollectionManager.getMap().size()).append("\n");
        line.append("Init date - ").append(CollectionManager.getDate()).append("\n");
        return line.toString();
    }

    /**
     *  Метод для получения имени команды info
     * @return имя
     */

    @Override
    public String getName() {
        return "info";
    }

    /**
     *  Метод для получения описания команды info
     * @return описание
     */

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

}
