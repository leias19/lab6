package data;

import data.generators.IdGenerator;
import system.LocalDateAdapter;
import system.Validator;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


public class HumanBeing implements Comparable<HumanBeing>, Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770150L;
    private int id;
    private String name;
    private Coordinates coordinates;
    @XmlTransient
    private LocalDate creationDate;
    private Boolean realHero;
    private boolean hasToothpick;
    private double impactSpeed;
    private String soundtrackName;
    private WeaponType weaponType;
    private Mood mood;
    private Car car;


    /**
     *  Конструктор для HumanBeing
     * @param data данные
     * @throws Exception ошибка ввода
     */
    public HumanBeing(String[] data) throws Exception{
        Validator.moreThanZero(data[1]);
        Validator.inputIsNotEmpty(data[2], "name");
        Validator.coordinateXIsRight(data[3]);
        Validator.coordinateYIsRight(data[4]);
        Validator.booleanNotNull(data[5], "realHero");
        Validator.booleanIsBoolean(data[6], "hasToothpick");
        Validator.doubleIsDouble(data[7], "impactSpeed");
        Validator.inputIsNotEmpty(data[8], "soundtrackName");
        Validator.weaponTypeIsRight(data[9]);
        Validator.moodIsRight(data[10]);
        Validator.inputIsNotEmpty(data[11], "car");
        Validator.booleanIsBoolean(data[12], "car");

        this.id = Integer.parseInt(data[1]);
        this.name = data[2];
        this.coordinates = new Coordinates(Integer.parseInt(data[3]), Long.parseLong(data[4]));
        this.creationDate = LocalDate.now();
        this.realHero = Boolean.parseBoolean(data[5]);
        this.hasToothpick = Boolean.parseBoolean(data[6]);
        this.impactSpeed = Double.parseDouble(data[7]);
        this.soundtrackName = data[8];
        this.weaponType = WeaponType.valueOf(data[9]);
        this.mood = Mood.valueOf(data[10]);
        this.car = new Car(data[11], Boolean.parseBoolean(data[12]));

    }

    /**
     *  Конструктор для HumanBeing
     */

    public HumanBeing(){
        this.id = IdGenerator.generateid();
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDate.now();
        this.realHero = false;
        this.hasToothpick = false;
        this.impactSpeed = 0;
        this.soundtrackName = null;
        this.weaponType = null;
        this.mood = null;
        this.car = null;
    }

    /**
     *  Конструктор для HumanBeing
     * @param id id
     */
    public HumanBeing(int id){
        this.id = id;
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDate.now();
        this.realHero = false;
        this.hasToothpick = false;
        this.impactSpeed = 0;
        this.soundtrackName = null;
        this.weaponType = null;
        this.mood = null;
        this.car = null;
    }

    /**
     *  Метод для вывода информации
     * @return информацию о человеке
     */

    @Override
    public String toString() {
        return "HumanBeing{" + "\n" +
                "id = " + id + " \n" +
                "name = '" + name + '\'' + "\n" +
                "coordinate_x = " + coordinates.getX() + "\n" +
                "coordinate_y = " + coordinates.getY() + "\n" +
                "creation_date = " + creationDate + "\n" +
                "real_hero = " + realHero + "\n" +
                "has_toothpick = " + hasToothpick + "\n" +
                "impact_speed = " + impactSpeed + "\n" +
                "soundtrack_name = '" + soundtrackName + '\'' + "\n" +
                "weapon_type = " + weaponType + "\n" +
                "mood = " + mood + "\n" +
                "car_name = " + car.getName()+ "\n" +
                "car_cool = " + car.getCool()+ "\n" +
                '}' + "\n";
    }


    /**
     *  Метод для получения id
     * @return id
     */

    public int getId() {
        return id;
    }

    /**
     *  Метод для установки id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *  Метод для получения имени
     * @return имя
     */


    public String getName() {
        return name;
    }

    /**
     *  Метод для установки имени
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Метод для получения координат
     * @return координаты
     */

    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     *  Метод для установки координат
     * @param coordinates координаты
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     *  Метод для получения даты создания
     * @return дата
     */

    @XmlElement(name = "creationdate")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     *  Метод для установки даты создания
     * @param creationDate дата
     */
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    /**
     *  Метод для получения реального героя
      * @return boolean
     */

    public Boolean getRealHero() {
        return realHero;
    }

    /**
     *  Метод для установки реального героя
     * @param realHero наличие реального героя
     */
    public void setRealHero(Boolean realHero){
        this.realHero = realHero;
    }

    /**
     *  Метод для получения зубочистки
     * @return boolean
     */

    public boolean getHasToothpick(){
        return hasToothpick;
    }

    /**
     *  Метод для установки зубочистки
     * @param hasToothpick наличие зубочистки
     */
    public void setHasToothpick(boolean hasToothpick){
        this.hasToothpick = hasToothpick;
    }

    /**
     *  Метод для получения импульса
     * @return  скорость импульса
     */

    public double getImpactSpeed(){
        return impactSpeed;
    }

    /**
     *  Метод для установки импульса
     * @param impactSpeed скорость импульса
     */
    public void setImpactSpeed(double impactSpeed){
        this.impactSpeed = impactSpeed;
    }

    /**
     *  Метод для получения названия саундтрека
     * @return название саундтрека
     */

    public String getSoundtrackName(){
        return soundtrackName;
    }

    /**
     *  Метод для установки названия саундтрека
     * @param soundtrackName название саундтрека
     */
    public void setSoundtrackName(String soundtrackName){
        this.soundtrackName = soundtrackName;
    }

    /**
     *  Метод для получения типа оружия
     * @return тип оружия
     */

    public WeaponType getWeaponType() {
        return weaponType;
    }

    /**
     *  Метод для установки типа оружия
     * @param weaponType тип оружия
     */
    public void setWeaponType(WeaponType weaponType){
        this.weaponType = weaponType;
    }

    /**
     *  Метод для получения типа настроения
     * @return настроение
     */

    public Mood getMood() {
        return mood;
    }

    /**
     *  Метод для установки типа настроения
     * @param mood настроение
     */
    public void setMood(Mood mood){
        this.mood = mood;
    }

    /**
     *  Метод для получения автомобиля
     * @return автомобиль
     */

    public Car getCar(){
        return car;
    }

    /**
     *  Метод для установки автомобиля
     * @param car автомобиль
     */
    public void setCar(Car car){
        this.car = car;
    }

    /**
     *  Метод для сравнения
     * @param humanBeing the object to be compared.
     * @return the value 0 if this object is equal to the argument
     */

    @Override
    public int compareTo(HumanBeing humanBeing) {
        return this.getId() - humanBeing.getId();
    }

}
