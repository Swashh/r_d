import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SpacesReader {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File("spaces.json"));

            for (JsonNode folderNode : rootNode.path("folders")) {
                for (JsonNode listNode : folderNode.path("lists")) {
                    System.out.println("List ID: " + listNode.path("id").asText());

                    String listName = listNode.path("name").asText().toLowerCase();
                    if (listName.startsWith("test")) {
                        JsonNode spaceNode = listNode.path("space");
                        String spaceName = spaceNode.path("name").asText("Unknown");
                        String spaceId = spaceNode.path("id").asText("Unknown");
                        System.out.printf("Space Name: %s, Space ID: %s%n", spaceName, spaceId);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
