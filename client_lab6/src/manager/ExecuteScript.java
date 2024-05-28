package manager;

import data.*;
import errors.IncorrectInputException;
import errors.RecursionException;
import errors.UnknownCommandException;
import errors.UnknownElementException;
import system.Client;
import system.Request;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExecuteScript {
    /**
     *  Метод для выполнения скрипта
     * @param requests запрос
     * @throws Exception исключение
     */
    public static void execute(Request requests) throws Exception {
        String filePath = requests.getKey();

        try {
            Scanner scanner = new Scanner(new FileReader(filePath));
            Client client = new Client();
            while (scanner.hasNextLine()) {
                String[] elements = scanner.nextLine().split(" ");
                String command = elements[0];

                if (command.equals("insert")) {
                    Request request = new Request(null, null, null);
                    request.setMessage(command);
                    String key = elements[1];

                    int id = Integer.parseInt(scanner.nextLine());
                    String name = scanner.nextLine();
                    int x = Integer.parseInt(scanner.nextLine());
                    long y = Long.parseLong(scanner.nextLine());
                    Coordinates coordinates = new Coordinates(x, y);
                    boolean realHero = Boolean.parseBoolean(scanner.nextLine());
                    boolean hasToothpick = Boolean.parseBoolean(scanner.nextLine());
                    double impactSpeed = Double.parseDouble(scanner.nextLine());
                    String soundtrackName = scanner.nextLine();
                    WeaponType weaponType = WeaponType.valueOf(scanner.nextLine().toUpperCase());
                    Mood mood = Mood.valueOf(scanner.nextLine().toUpperCase());
                    String carName = scanner.nextLine();
                    boolean carCool = Boolean.parseBoolean(scanner.nextLine());
                    Car car = new Car(carName, carCool);

                    HumanBeing humanBeing = new HumanBeing(id);
                    humanBeing.setName(name);
                    humanBeing.setCoordinates(coordinates);
                    humanBeing.setRealHero(realHero);
                    humanBeing.setHasToothpick(hasToothpick);
                    humanBeing.setImpactSpeed(impactSpeed);
                    humanBeing.setSoundtrackName(soundtrackName);
                    humanBeing.setWeaponType(weaponType);
                    humanBeing.setMood(mood);
                    humanBeing.setCar(car);

                    request.setMessage("insert");
                    request.setHumanBeing(humanBeing);
                    request.setKey(key);
                    String echo = client.sendEcho(request);
                    System.out.println("Ответ сервера: \n" + echo);
                } else if (command.equals("update_id")) {
                    Request request = new Request(null, null, null);
                    request.setMessage(command);
                    String key = elements[1];

                    int neededId = Integer.parseInt(scanner.nextLine());
                    String name = scanner.nextLine();
                    int x = Integer.parseInt(scanner.nextLine());
                    long y = Long.parseLong(scanner.nextLine());
                    Coordinates coordinates = new Coordinates(x, y);
                    boolean realHero = Boolean.parseBoolean(scanner.nextLine());
                    boolean hasToothpick = Boolean.parseBoolean(scanner.nextLine());
                    double impactSpeed = Double.parseDouble(scanner.nextLine());
                    String soundtrackName = scanner.nextLine();
                    WeaponType weaponType = WeaponType.valueOf(scanner.nextLine().toUpperCase());
                    Mood mood = Mood.valueOf(scanner.nextLine().toUpperCase());
                    String carName = scanner.nextLine();
                    boolean carCool = Boolean.parseBoolean(scanner.nextLine());
                    Car car = new Car(carName, carCool);

                    HumanBeing newHumanBeing = new HumanBeing(neededId);
                    newHumanBeing.setName(name);
                    newHumanBeing.setCoordinates(coordinates);
                    newHumanBeing.setRealHero(realHero);
                    newHumanBeing.setHasToothpick(hasToothpick);
                    newHumanBeing.setImpactSpeed(impactSpeed);
                    newHumanBeing.setSoundtrackName(soundtrackName);
                    newHumanBeing.setWeaponType(weaponType);
                    newHumanBeing.setMood(mood);
                    newHumanBeing.setCar(car);

                    request.setMessage("update_id " + neededId);
                    request.setHumanBeing(newHumanBeing);
                    request.setKey(key);
                    String echo = client.sendEcho(request);
                    System.out.println("Ответ сервера: \n" + echo);
                } else if (command.equals("replace_if_greater")) {
                    Request request = new Request(null, null, null);
                    request.setMessage(command);
                    String key = elements[1];

                    String name = scanner.nextLine();
                    int x = Integer.parseInt(scanner.nextLine());
                    long y = Long.parseLong(scanner.nextLine());
                    Coordinates coordinates = new Coordinates(x, y);
                    boolean realHero = Boolean.parseBoolean(scanner.nextLine());
                    boolean hasToothpick = Boolean.parseBoolean(scanner.nextLine());
                    double impactSpeed = Double.parseDouble(scanner.nextLine());
                    String soundtrackName = scanner.nextLine();
                    WeaponType weaponType = WeaponType.valueOf(scanner.nextLine().toUpperCase());
                    Mood mood = Mood.valueOf(scanner.nextLine().toUpperCase());
                    String carName = scanner.nextLine();
                    boolean carCool = Boolean.parseBoolean(scanner.nextLine());
                    Car car = new Car(carName, carCool);

                    HumanBeing humanBeing = new HumanBeing();
                    humanBeing.setName(name);
                    humanBeing.setCoordinates(coordinates);
                    humanBeing.setRealHero(realHero);
                    humanBeing.setHasToothpick(hasToothpick);
                    humanBeing.setImpactSpeed(impactSpeed);
                    humanBeing.setSoundtrackName(soundtrackName);
                    humanBeing.setWeaponType(weaponType);
                    humanBeing.setMood(mood);
                    humanBeing.setCar(car);

                    request.setMessage("replace_if_greater");
                    request.setHumanBeing(humanBeing);
                    request.setKey(key);
                    String echo = client.sendEcho(request);
                    System.out.println("Ответ сервера: \n" + echo);
                } else if (command.equals("exit")) {
                    System.exit(1);
                }else if (command.equals("execute_script")) {
                    if (elements[1].equals("text.txt")){
                        System.err.println("произошла рекурсия");
                    }
                } else {
                    Request request = new Request(command);
                    request.setMessage(command);
                    String echo = client.sendEcho(request);
                    System.out.println("Ответ сервера: \n" + echo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        } catch (Exception e) {
            System.out.println("неправильный ввод");
        }
    }

    /**
     *  Метод для получения имени команды execute_script
     * @return имя
     */

    public String getName() {
        return "execute_script file_name";
    }

    /**
     *  Метод для получения описания команды execute_script
     * @return описание
     */

    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}

