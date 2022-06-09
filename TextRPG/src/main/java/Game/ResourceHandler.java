package Game;

import Game.GameData.Entities.Entity;
import Game.GameData.GameWorld;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.security.jgss.GSSUtil;
import org.apache.commons.io.FilenameUtils;

import java.io.DataInput;
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

        String worldName = FilenameUtils.getBaseName(sourceFile.getName());
        int worldSize = worldFileNode.get("WorldSize").asInt();
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
                    System.out.println(createdObject);
                }
            }
        }
    }

}
