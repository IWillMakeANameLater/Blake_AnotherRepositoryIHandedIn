package User;

import Game.GameData.Entities.Entity;
import Game.GameData.Enums.Direction;

import User.Commands.*;

import java.util.*;

/**
 * The main way the user interacts with the game.
 * Takes in commands and tries to interpret them into actions.
 */
public class UserPromptsHandler {
    private Player controlledPlayer;
    private final Scanner userInputHandler;
    private HashMap<String, Command> playerCommands;
    public UserPromptsHandler(Player controlledPlayer){
        this.controlledPlayer = controlledPlayer;
        this.userInputHandler = new Scanner(System.in);


        playerCommands = new HashMap<>();

        //Possible Commands
        playerCommands.put("grab", new Grab());
        playerCommands.put("move", new Move());
        playerCommands.put("look", new Look());
        playerCommands.put("help", new Help());
        playerCommands.put("drop", new Drop());

        // Initial Steps

        System.out.println("What will you name your character?");
        controlledPlayer.setName(userInputHandler.next());
        userInputHandler.nextLine();

        System.out.println("You are in" + controlledPlayer.getCurrentRoom().observe());
        System.out.println("\nUse 'help' to show a list of commands.");
        mainPromptLoop();
    }

    /**
     * Main gameplay loop
     * Every step, takes the user's inputs and parses it into a command to be run if possible.
     * In the future, each step of this loop would also serve as a 'turn' for fighting and moving entities between rooms
     */
    public void mainPromptLoop(){
        while(true){
            String userInput = userInputHandler.nextLine();
            parseCommand(userInput);
        }
    }

    private void parseCommand(String command){
        String[] commandParts = command.split(" ");
        String commandStart = commandParts[0];
        String[] commandArgs = Arrays.copyOfRange(commandParts,1, commandParts.length + 1);

        Command inputtedCommand = playerCommands.get(commandStart);
        if(inputtedCommand != null){
            inputtedCommand.run(controlledPlayer, commandArgs);
        }else{
            System.out.println("Command was not recognized");
        }
    }
}
