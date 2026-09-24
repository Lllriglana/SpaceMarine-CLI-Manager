package Managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonManager {
    private CollectionManager collectionManager;
    private BufferedReader br;
    private ObjectMapper mapper = new ObjectMapper();

    public JsonManager(CollectionManager collectionManager, BufferedReader br) {
        this.collectionManager = collectionManager;
        this.br = br;
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    }

    public void save() {
        File file = askFileName();
        
        if (file == null) return;
        
        try {
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(file, collectionManager.getAll());
        } catch (IOException e) {
            System.out.println("Ошибка: не удалось записать коллекцию в файл");
        }
    }

    private File askFileName() {
        try {
            System.out.println("Введите имя для файла: ");
            String nameFile = br.readLine();

            if (nameFile == null || nameFile.isBlank()) {
                System.out.println("Ошибка: имя файла не может быть пустым");
                return null;
            }

            if (!nameFile.toLowerCase().endsWith(".json")) nameFile += ".json";


            nameFile = nameFile.strip();
            File dir = new File("data");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            return new File("data/" + nameFile);
        } catch (IOException e) {
            System.out.println("Ошибка ввода");
            return null;
        }
    }

}