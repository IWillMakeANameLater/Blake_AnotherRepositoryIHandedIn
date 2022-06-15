package Game;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ResourceHandler test = new ResourceHandler(new File("src/main/resources/GameDataFiles/Overworld.json"));
        test.loadFile();
        System.out.println("Ha");
    }
}
