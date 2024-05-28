package data.generators;

import java.util.ArrayList;

public class IdGenerator {
    private static ArrayList<Integer> idList = new ArrayList<>();
    /**
     *  Пустой конструктор для Id
     */
    public IdGenerator(){
        idList = new ArrayList<>();
    }

    /**
     *  Метод для генерации Id
     * @return id
     */
    public static Integer generateid(){
        Integer id = (int)Math.floor(Math.random() * 386800) + 244;
        while (idList.contains(id)){
            id = (int)Math.floor(Math.random() * 386800) + 244;
        }
        idList.add(id);
        return id;
    }

    /**
     *  Метод для проверки Id
     * @param id id
     * @return true или false
     */
    public static boolean idIsUnique(int id){
        if (idList.contains(id)){
            return false;
        }else{
            return true;
        }
    }

    /**
     *  Метод для удаления Id
     * @param id id
     */
    public static void remove(int id){
        idList.remove(id);
    }

    /**
     *  Метод для добавления Id
     * @param id id
     */
    public static void insert(int id){
        idList.add(id);
    }
}
