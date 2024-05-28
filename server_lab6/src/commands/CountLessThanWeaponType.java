package commands;

import data.HumanBeing;
import data.WeaponType;
import managers.CollectionManager;
import system.Request;

public class CountLessThanWeaponType implements Command {
    /**
     *  Метод для выполнения команды count_less_than_weight
     * @param request аргумент
     */
    @Override
    public String execute(Request request)  {
        StringBuilder line = new StringBuilder();
        WeaponType otherWeaponType = WeaponType.valueOf(request.getKey().toUpperCase());
        int counter = (int) CollectionManager.getMap().entrySet().stream().filter(entry -> entry.getValue().getWeaponType().compareTo(otherWeaponType) > 0).count();
        line.append("количество элементов, значение поля weaponType которых меньше заданного = ").append(counter);
        return line.toString();
    }

    /**
     *  Метод для получения имени команды count_less_than_weight
     * @return имя
     */

    @Override
    public String getName() {
        return "count_less_than_weapon_type";
    }

    /**
     *  Метод для получения описания команды count_less_than_weight
     * @return описание
     */

    @Override
    public String getDescription() {
        return "вывести количество элементов, значение поля weaponType которых меньше заданного";
    }
}
