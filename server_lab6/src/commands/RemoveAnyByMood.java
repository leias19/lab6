package commands;


import data.HumanBeing;
import data.Mood;
import managers.CollectionManager;
import system.Request;

import java.util.Map;


public class RemoveAnyByMood implements Command {
    /**
     * Метод для выполнения команды remove_any_by_mood
     *
     * @param request аргумент
     */
    @Override
    public String execute(Request request) {
        StringBuilder line = new StringBuilder();
        try {
            Mood moodToRemove = Mood.valueOf(request.getKey().toUpperCase());
            var result = CollectionManager.getMap().entrySet()
                    .removeIf(entry -> entry.getValue().getMood() == moodToRemove);
            if (result){
                line.append("удаление выполнено");
            } else {
                line.append("элемент с таким настроением не найден");
            }
        } catch (Exception e) {
            line.append(e.getMessage());
        }
        return line.toString();
    }





    /**
     * Метод для получения имени команды remove_any_by_mood
     *
     * @return имя
     */

    @Override
    public String getName() {
        return "remove_any_by_mood";
    }

    /**
     * Метод для получения описания команды remove_any_by_mood
     *
     * @return описание
     */

    @Override
    public String getDescription() {
        return "удалить из коллекции один элемент, значение поля mood которого эквивалентно заданному";
    }
}

