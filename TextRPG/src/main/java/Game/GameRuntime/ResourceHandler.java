package Game.GameRuntime;

import Game.GameData.Entities.Entity;
import Game.GameData.Map.GameWorld;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ResourceHandler {
    private final File sourceFile;
    private GameWorld loadedWorld;

    public ResourceHandler(File sourceFile){
        this.sourceFile = sourceFile;
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode worldFileNode = objectMapper.readTree(sourceFile);

        int worldSize = worldFileNode.get("WorldSize").asInt();
        String worldName = worldFileNode.get("WorldName").asText();
        loadedWorld = new GameWorld(worldSize, worldName);

        Iterator<JsonNode> worldFileFields = worldFileNode.elements();
        Iterator<String> worldFileFieldNames = worldFileNode.fieldNames();

        while(worldFileFields.hasNext()){
            JsonNode worldFileField = worldFileFields.next();
            String worldFileFieldName = worldFileFieldNames.next();
            if(worldFileField.isArray()){
                for(JsonNode fieldObject:worldFileField){
                    Class className = Class.forName(worldFileFieldName);
                    Entity createdObject = (Entity) objectMapper.treeToValue(fieldObject, className);

                    createdObject.setWorld(loadedWorld);
                    if(fieldObject.has("currentRoom")){
                        createdObject.setCurrentRoom(fieldObject.get("currentRoom").asText());
                    }
                }
            }
        }
    }

    public GameWorld getLoadedWorld(){
        return loadedWorld;
    }
}
