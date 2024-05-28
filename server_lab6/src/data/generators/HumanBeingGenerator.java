package data.generators;

import data.*;
import errors.IncorrectInputException;
import system.Validator;

import java.util.Scanner;

public class HumanBeingGenerator {
    /**
     * Метод для создания человека
     * @param id id
     * @return Человек
     * @throws IncorrectInputException Исключение при некорректном вводе
     */
    public static HumanBeing createHumanBeing(Integer id) throws IncorrectInputException {
        System.out.println("Generate...");

        Scanner scanner = new Scanner(System.in);

        String input;
        int x;
        long y;
        Coordinates coordinates;
        String name;
        boolean cool;
        Car car;

        HumanBeing humanBeing;
        if (id == 0) {
            humanBeing = new HumanBeing();
        } else {
            humanBeing = new HumanBeing(id);
        }


        while (true) {
            try {
                System.out.println("Введите имя: ");
                input = scanner.nextLine();
                humanBeing.setName(input);
                if (!(input.isEmpty())){
                    break;
                }else{
                    System.out.println("имя не может быть пустым");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите координату x (максимальное значение 5): ");
                x = Integer.parseInt(scanner.nextLine());
                if(x<=5){
                    break;
                }else{
                    System.out.println("слишком большое значение");
                }
            } catch (Exception e) {
                System.out.println("необходимо ввести число");
            }
        }


        while (true) {
            try {
                System.out.println("Введите координату y (максимальное значение 503): ");
                y = Long.parseLong(scanner.nextLine());
                if(y<=503){
                    break;
                }else{
                    System.out.println("слишком большое значение");
                }
            } catch (Exception e) {
                System.out.println("необходимо ввести число");
            }
        }

        coordinates = new Coordinates(x, y);
        humanBeing.setCoordinates(coordinates);

        while (true) {
            try {
                System.out.println("Настоящий ли герои? true или false ");
                input = scanner.nextLine();
                if (Validator.intIsInt(input)){
                    int index = Integer.parseInt(input);
                    if (index == 1){
                        humanBeing.setRealHero(true);
                        break;
                    }if (index == 0){
                        humanBeing.setRealHero(false);
                        break;
                    }else{
                        System.out.println("ответ не может задаваться данным значением");
                    }
                }else{
                    input = input.toLowerCase();
                    humanBeing.setRealHero(Boolean.parseBoolean(input));
                    if (input.equals("true") || input.equals("false")){
                        break;
                    }else{
                        System.out.println("ответ не может задаваться данным значением");
                    }
                }
            } catch (Exception e) {
                System.out.println("ответ не может задаваться данным значением");
            }
        }

        while (true) {
            try {
                System.out.println("Имеет ли зубочистку? true или false ");
                input = scanner.nextLine();
                if (Validator.intIsInt(input)){
                    int index = Integer.parseInt(input);
                    if (index == 1){
                        humanBeing.setHasToothpick(true);
                        break;
                    }if (index == 0){
                        humanBeing.setHasToothpick(false);
                        break;
                    }else{
                        System.out.println("ответ не может задаваться данным значением");
                    }
                }else{
                    input = input.toLowerCase();
                    humanBeing.setHasToothpick(Boolean.parseBoolean(input));
                    if (input.equals("true") || input.equals("false")){
                        break;
                    }else{
                        System.out.println("ответ не может задаваться данным значением");
                    }
                }
            } catch (Exception e) {
                System.out.println("ответ не может задаваться данным значением");
            }
        }



        while (true) {
            try {
                System.out.println("Введите скорость удара: ");
                input = scanner.nextLine();
                if (Double.parseDouble(input) > 0) {
                    break;
                }else {
                    System.out.println("скорость не может быть отрицательной");
                }
                humanBeing.setImpactSpeed(Double.parseDouble(input));
            } catch (Exception e) {
                System.out.println("ответ не может задаваться данным значением");
            }
        }

        while (true) {
            try {
                System.out.println("Введите название саундтрека: ");
                input = scanner.nextLine();
                humanBeing.setSoundtrackName(input);
                if (!(input.isEmpty())){
                    break;
                }else{
                    System.out.println("название саундтрека не может быть пустым");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        while (true) {
            try {
                System.out.println("Введите номер или тип оружия из доступных вариантов: HAMMER" + "   KNIFE" + "   BAT");
                input = scanner.nextLine();
                if (Validator.intIsInt(input)){
                    int index = Integer.parseInt(input);
                    WeaponType type = switch (index) {
                        case 1 -> WeaponType.HAMMER;
                        case 2 -> WeaponType.KNIFE;
                        case 3 -> WeaponType.BAT;
                        default -> null;
                    };
                    if (type == null){
                        System.out.println("слишком большое значение");
                    }else{
                        humanBeing.setWeaponType(type);
                        break;
                    }
                }else {
                    input = input.toUpperCase();
                    humanBeing.setWeaponType(WeaponType.valueOf(input));
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Введите настроение из доступных вариантов: SADNESS" + "   SORROW" + "   LONGING" + "   GLOOM" + "   CALM");
                input = scanner.nextLine();
                if (Validator.intIsInt(input)){
                    int index = Integer.parseInt(input);
                    Mood type = switch (index) {
                        case 1 -> Mood.SADNESS;
                        case 2 -> Mood.SORROW;
                        case 3 -> Mood.LONGING;
                        case 4 -> Mood.GLOOM;
                        case 5 -> Mood.CALM;
                        default -> null;
                    };
                    if (type == null){
                        System.out.println("слишком большое значение");
                    }else{
                        humanBeing.setMood(type);
                        break;
                    }

                }else{
                    input = input.toUpperCase();
                    humanBeing.setMood(Mood.valueOf(input));
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        while (true) {
            try {
                System.out.println("Введите название машины: ");
                name = scanner.nextLine();
                if (!(name.isEmpty())){
                    break;
                }else{
                    System.out.println("название машины не может быть пустым");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Крутая ли машина? true или false ");
                input = scanner.nextLine();
                if (Validator.intIsInt(input)){
                    int index = Integer.parseInt(input);
                    if (index == 1){
                        cool = true;
                        break;
                    }if (index == 0){
                        cool = false;
                        break;
                    }else{
                        System.out.println("ответ не может задаваться данным значением");
                    }
                }else{
                    input = input.toLowerCase();
                    cool = Boolean.parseBoolean(input);
                    if (input.equals("true") || input.equals("false")){
                        break;
                    }else{
                        System.out.println("ответ не может задаваться данным значением");
                    }
                }
            } catch (Exception e) {
                System.out.println("ответ не может задаваться данным значением");
            }
        }

        car = new Car(name, cool);
        humanBeing.setCar(car);

        return humanBeing;
    }
}
