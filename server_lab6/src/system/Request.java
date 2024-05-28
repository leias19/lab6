package system;

import data.HumanBeing;
import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {

    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private String message = null;
    private String key = null;
    private HumanBeing humanBeing = null;

    /**
     *  Метод для создания запроса
     * @param message сообщение
     * @param key ключ
     * @param humanBeing человек
     */
    public Request(String message, String key, HumanBeing humanBeing) {
        this.message = message;
        this.key = key;
        this.humanBeing = humanBeing;
    }

    /**
     *  Метод для создания запроса
     * @param message сообщение
     */
    public Request(String message) {
        this.message = message;
    }

    /**
     *  Метод для получения сообщения
     * @return Сообщение
     */

    public String getMessage() {
        return message;
    }

    /**
     *  Метод для установки сообщения
     * @param message   сообщение
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *  Метод для получения ключа
     * @return Ключ
     */
    public String getKey() {
        return key;
    }

    /**
     *  Метод для установки ключа
     * @param key ключ
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     *  Метод для получения человека
     * @return Человек
     */
    public HumanBeing getHumanBeing() {
        return humanBeing;
    }

    /**
     *  Метод для установки человека
     * @param humanBeing человек
     */
    public void setHumanBeing(HumanBeing humanBeing) {
        this.humanBeing = humanBeing;
    }

}


