package data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.io.Serial;
import java.io.Serializable;


@XmlType(name = "Mood")
@XmlEnum
/**
 *  Перечисление состояний чувства
 */
public enum Mood  {
    @XmlEnumValue("SADNESS")
    SADNESS,
    @XmlEnumValue("SORROW")
    SORROW,
    @XmlEnumValue("LONGING")
    LONGING,
    @XmlEnumValue("GLOOM")
    GLOOM,
    @XmlEnumValue("CALM")
    CALM
}
