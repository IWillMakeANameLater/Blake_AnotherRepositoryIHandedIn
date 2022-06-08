package Game;

import Game.GameData.GameWorld;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ResourceHandler {
    private final File sourceFile;
    private GameWorld loadedWorld;

    public ResourceHandler(File sourceFile){
        this.sourceFile = sourceFile;
    }

    public void loadFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode worldFileNode = objectMapper.readTree(sourceFile);


        Iterator<JsonNode> worldFileFields = worldFileNode.elements();
        Iterator<String> worldFileFieldNames = worldFileNode.fieldNames();
        while(worldFileFields.hasNext()){
            JsonNode worldFileField = worldFileFields.next();
            String worldFileFieldName = worldFileFieldNames.next();
            if(worldFileField.isArray()){
                System.out.println(worldFileField);
                System.out.println(worldFileFieldName);
            }
            continue;
        }
    }

}
