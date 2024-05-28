package managers;

import data.Community;
import data.HumanBeing;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class FileManager {
    /**
     *  Метод для считывания файла
     * @param filePath путь к файлу
     * @return список людей
     */

    public static Community readFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Файл не найден");
            return new Community();
        }
        StringBuilder stringBuilderHuman = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stringBuilderHuman.append(line).append("\n");

            }
            if (stringBuilderHuman.isEmpty()) {
                System.out.println("Похоже у вас еще нет объектов");
            } else {
                JAXBContext context = JAXBContext.newInstance(Community.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                return (Community) unmarshaller.unmarshal(new StringReader(stringBuilderHuman.toString()));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден или вы не можете его прочитать");
        } catch (JAXBException e) {
            System.err.println("Что-то пошло не так при считывании из файла, попробуйте снова");
        }
        return new Community();
    }

    /**
     *  Метод для записи в файл
     * @param collection коллекция
     */

    public static void writeFile(Map<String, HumanBeing> collection) {
        String filePath = "example.xml";

        try {
            File file = new File(filePath);

            Community community = new Community();
            for (String key: collection.keySet()) {
                community.addPersonToHuman(key, collection.get(key));
            }

            FileOutputStream fos = new FileOutputStream(file, false);
            Writer outputStreamWriter = new BufferedWriter(new OutputStreamWriter(fos));

            JAXBContext context = JAXBContext.newInstance(HumanBeing.class, Community.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(community, outputStreamWriter);

            outputStreamWriter.close();
            System.out.println("Данные успешно записаны в XML файл!");
        } catch (IOException | JAXBException e) {
            System.err.println("Что-то пошло не так при записи в файл, попробуйте снова");
        } catch (SecurityException e) {
            System.err.println("Недостаточно прав доступа для доступа к файлу");
        }
    }


}
