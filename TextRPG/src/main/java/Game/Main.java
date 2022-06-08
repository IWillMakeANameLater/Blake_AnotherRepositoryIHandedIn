package Game;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ResourceHandler test = new ResourceHandler(new File("src/main/resources/GameDataFiles/Overworld.json"));
        test.loadFile();
    }
}
