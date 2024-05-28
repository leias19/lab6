package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serial;
import java.io.Serializable;
import java.util.TreeMap;

@XmlType(name = "humans")
@XmlRootElement
public class Community implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770154L;
    @XmlElementWrapper(name = "added-humans", nillable = true)
    @XmlElement
    public TreeMap<String, HumanBeing> humans = new TreeMap<>();

    /**
     * Метод для добавления элемента
     * @param key ключ
     * @param humanBeing человек
     */
    public void addPersonToHuman(String key, HumanBeing humanBeing) {
        humans.put(key, humanBeing);
    }

    /**
     *  Метод для получения элемента
     * @return Коллекцию
     */

    public TreeMap<String, HumanBeing> getHuman() {
        return humans;
    }
}
