import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPractice {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Path path = Path.of("data", "practice.json");

        String json2 = Files.readString(path);

        JsonNode root2 = mapper.readTree(json2);

        System.out.println(root2);


        String json1 = """
                {
                  "name": "Titus",
                  "health": 100
                }
                """;

        JsonNode root1 = mapper.readTree(json1);

        String name = root1.get("name").asText();

        String health = root1.get("health").asText();

        System.out.println(name + " : " + health);
    }
}