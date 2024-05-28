package data;


import java.io.Serial;
import java.io.Serializable;

public class Coordinates implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770152L;
    private Integer x;
    private Long y;

    /**
     *  Пустой онструктор для координат
     */
    public Coordinates(){}

    /**
     *  Конструктор для координат
     * @param x x
     * @param y y
     */
    public Coordinates(Integer x, Long y){
        this.x = x;
        this.y = y;
    }

    /**
     *  Метод для получения координат
     * @return x
     */


    public Integer getX(){
        return x;
    }

    /**
     *  Метод для установки координат
     * @param x x
     */
    public void setX(Integer x){
        this.x = x;
    }

    /**
     *  Метод для получения координат
     * @return y
     */

    public Long getY(){
        return y;
    }

    /**
     *  Метод для установки координат
     * @param y y
     */

    public void setY(Long y){
        this.y = y;
    }

    /**
     *  Метод для вычисления вектора
     * @param x x
     * @param y y
     * @return вектор
     */

    public int getVektor(int x, long y){
        return (int) (Math.sqrt(x^2 + y^2));
    }
}
