package Managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Queue;

public class FileManager {
    public Queue<String> readFile(String filePath) {
        Queue<String> queue = new ArrayDeque<>();
        Path path = Path.of("src", filePath);

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                queue.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return queue;
    }
}