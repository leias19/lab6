package system;

import data.Mood;
import data.WeaponType;
import errors.IncorrectInputException;

public class Validator {
    /**
     * Метод для проверки положительного числа
     * @param args  - аргумент
     * @throws IncorrectInputException ошибка при отрицательном числе
     */
    public static void moreThanZero(String args) throws IncorrectInputException {
        try {
            int id = Integer.parseInt(args);
            if (id < 0) {
                throw new IncorrectInputException("id");
            }
        } catch (Exception e) {
            throw new IncorrectInputException("id");
        }
    }

    /**
     *  Метод для проверки координат
     * @param args  - аргумент
     * @throws IncorrectInputException ошибка при отрицательном числе
     * @throws NullPointerException ошибка при отрицательном числе
     */
    public static void coordinateXIsRight(String args) throws IncorrectInputException, NullPointerException {
        try {
            int x = Integer.parseInt(args);
            if (x > 5) {
                throw new IncorrectInputException("x");
            }
            throw new NullPointerException("x");
        } catch (Exception e) {
            throw new IncorrectInputException("x");
        }
    }

    /**
     *  Метод для проверки координат
     * @param args  - аргумент
     * @throws IncorrectInputException ошибка при отрицательном числе
     * @throws NullPointerException ошибка при отрицательном числе
     */

    public static void coordinateYIsRight(String args) throws IncorrectInputException, NullPointerException {
        try {
            long y = Long.parseLong(args);
            if (y > 503) {
                throw new IncorrectInputException("y");
            }
            throw new NullPointerException("y");
        } catch (Exception e) {
            throw new IncorrectInputException("y");
        }
    }

    /**
     *  Метод для проверки логического значения
     * @param args - аргумент
     * @param data - ошибка при отрицательном числе
     * @throws NullPointerException ошибка при отрицательном числе
     */

    public static void booleanNotNull(String args, String data) throws NullPointerException {
        try{
            Boolean value = Boolean.parseBoolean(args);
            throw new NullPointerException(data);
        }catch (Exception e){
            System.out.println("Введено некорректное значение");
        }
    }

    /**
     *  Метод для проверки логического значения
     * @param args - аргумент
     * @param data - ошибка при отрицательном числе
     * @throws IncorrectInputException ошибка при отрицательном числе
     */

    public static void booleanIsBoolean(String args, String data) throws IncorrectInputException {
        try{
            Boolean value = Boolean.parseBoolean(args);
            throw new IncorrectInputException(data);
        }catch (Exception e){
            throw new IncorrectInputException(data);
        }
    }

    /**
     *  Метод для проверки целого числа
     * @param args - аргумент
     * @return boolean
     */

    public static boolean intIsInt(String args) {
        try{
            int value = Integer.parseInt(args);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     *  Метод для проверки вещественного числа
     * @param args - аргумент
     * @param data - ошибка при отрицательном числе
     * @throws IncorrectInputException ошибка при отрицательном числе
     */

    public static void doubleIsDouble(String args, String data) throws IncorrectInputException {
        try{
            double value = Double.parseDouble(args);
            throw new IncorrectInputException(data);
        }catch (Exception e){
            throw new IncorrectInputException(data);
        }
    }

    /**
     *  Метод для проверки вещественного числа
     * @param args - аргумент
     * @throws IncorrectInputException ошибка при отрицательном числе
     */



    public static void moodIsRight(String args) throws IncorrectInputException {
        try {
            Mood.valueOf(args);
        } catch (Exception e) {
            throw new IncorrectInputException("Mood");
        }
    }

    /**
     *  Метод для проверки вещественного числа
     * @param args - аргумент
     * @throws IncorrectInputException ошибка при отрицательном числе
     */

    public static void weaponTypeIsRight(String args) throws IncorrectInputException {
        try {
            WeaponType.valueOf(args);
        } catch (Exception e) {
            throw new IncorrectInputException("WeaponType");
        }
    }

    /**
     *  Метод для проверки вещественного числа
     * @param args - аргумент
     * @param data  - ошибка при отрицательном числе
     * @throws IncorrectInputException ошибка при отрицательном числе
     */

    public static void inputIsNotEmpty(String args, String data) throws IncorrectInputException{
        if (args.isEmpty() || args.trim().isEmpty()) {
            throw new IncorrectInputException(data);
        }
    }


}
