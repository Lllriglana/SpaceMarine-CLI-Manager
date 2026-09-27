package Managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import Model.SpaceMarine;

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

    public boolean save() {
        File file = askFileName();
        
        if (file == null) return false;
        
        try {
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(file, collectionManager.getAll());
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка: не удалось записать коллекцию в файл");
            return false;
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

    public void loader(String[] args) {
        String nameOfFile;

        if (args.length > 0) {
            nameOfFile = args[0];
            if (!nameOfFile.toLowerCase().endsWith(".json")) nameOfFile += ".json";
        } else {
            nameOfFile = "default.json";
        }

        Path path = Path.of("data", nameOfFile);

        try {
            if (!nameOfFile.equals("default.json") && !Files.exists(path)) { 
                System.out.println("Файл '" + nameOfFile + "' не найден, загрузка выполнится из 'default.json'.");

                path = Path.of("data", "default.json");

                if (!Files.exists(path)) {
                    Files.createDirectories(path.getParent());
                    mapper.writeValue(path.toFile(), List.of());
                }
            } else if (!nameOfFile.equals("default.json") && Files.exists(path)) {
                System.out.println("Загрузка выполнится из '" + nameOfFile + "'.");
            }

            if (nameOfFile.equals("default.json")) {
                System.out.println("Загрузка выполнится из 'default.json'.");

                if (!Files.exists(path)) {
                    Files.createDirectories(path.getParent());
                    mapper.writeValue(path.toFile(), List.of());
                } 
            }

            collectionManager.setCollection( 
                new LinkedList<>(
                    mapper.readValue(path.toFile(), new TypeReference<List<SpaceMarine>>(){}) 
                    )
            );
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке файла '" + path + "'.");
            try {
                Files.createDirectories(path.getParent());
                mapper.writeValue(path.toFile(), List.of());
                System.out.println("Коллекция пересоздана пустой.");
            } catch (IOException ex) {
                System.out.println("Не удалось пересоздать файл: " + ex.getMessage());
            }
        }
    }

}