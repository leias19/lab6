package data;


import java.io.Serial;
import java.io.Serializable;

public class Car implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770151L;
    private String name;
    private boolean cool;

    /**
     *  Пустой конструктор для машины
     */
    public Car(){}

    /**
     *  Конструктор для машины
     * @param name имя
     * @param cool состояние
     */
    public Car(String name, boolean cool){
        this.name = name;
        this.cool = cool;
    }

    /**
     *  Метод для получения имени
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     *  Метод для установки имени
     * @param name name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     *  Метод для получения состояния
     * @return cool
     */

    public boolean getCool(){
        return cool;
    }

    /**
     *  Метод для установки состояния
     * @param cool cool
     */

    public void setCool(boolean cool){
        this.cool = cool;
    }
}