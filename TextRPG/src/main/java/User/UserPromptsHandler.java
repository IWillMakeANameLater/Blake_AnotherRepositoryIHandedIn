package User;

import Game.GameData.Entities.Entity;
import Game.GameData.Enums.Direction;

import java.util.Objects;
import java.util.Scanner;

public class UserPromptsHandler {
    private Player controlledPlayer;
    private final Scanner userInputHandler;

    public UserPromptsHandler(Player controlledPlayer){
        this.controlledPlayer = controlledPlayer;
        this.userInputHandler = new Scanner(System.in);
        mainPromptLoop();
    }

    public void mainPromptLoop(){
        while(true){
            String userInput = userInputHandler.nextLine();
            parseCommand(userInput);
        }
    }

    public void parseCommand(String command){
        String[] commandParts = command.split(" ");
        if(commandParts[0].equals("move")){
            switch(commandParts[1]){
                case("north") -> {
                    controlledPlayer.Move(Direction.NORTH);
                }
                case("east") -> {
                    controlledPlayer.Move(Direction.EAST);
                }
                case("south") -> {
                    controlledPlayer.Move(Direction.SOUTH);
                }
                case("west") -> {
                    controlledPlayer.Move(Direction.WEST);
                }
            }
            System.out.println(controlledPlayer.getName() + " moved " + commandParts[1]);
        } else if(commandParts[0].equals("look")){
            Entity foundEntity = controlledPlayer.getCurrentRoom().retrieveFirst(commandParts[1]);
            if(foundEntity != null){
                System.out.println(foundEntity.observe());
            }
            System.out.println("Nothing found.");
        }
    }
}
