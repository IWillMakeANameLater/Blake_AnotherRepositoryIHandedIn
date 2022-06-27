package Game.GameRuntime;

import User.Player;
import User.UserPromptsHandler;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ResourceHandler test = new ResourceHandler(new File("src/main/resources/GameDataFiles/Overworld.json"));
        test.loadFile();
        Player testPlayer = new Player();
        testPlayer.setWorld(test.getLoadedWorld());
        testPlayer.setCurrentRoom(test.getLoadedWorld().roomAt(0,0));

        new UserPromptsHandler(testPlayer); // Start Game

    }
}
