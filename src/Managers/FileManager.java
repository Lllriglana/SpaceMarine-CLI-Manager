package Managers;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Queue;

public class FileManager {
    public Queue<String> readFile(String filePath) {
        Queue<String> queue = new ArrayDeque<>();
        Path path = Path.of("src", filePath);

        try {
            for (String line : Files.readAllLines(path, StandardCharsets.UTF_8)) {
                line = line.strip();

                if (!line.isEmpty()) {
                    queue.add(line);
                }
            } 
        } catch (Exception e) {
            System.out.println("Не удалось прочитать файл: " + path);
        }
        
        return queue;
    }
}