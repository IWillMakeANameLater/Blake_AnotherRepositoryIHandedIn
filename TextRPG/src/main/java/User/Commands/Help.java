package User.Commands;

import User.Player;

/**
 * Command to show more information about a command or all commands in general.
 */
public class Help extends Command{

    @Override
    public void run(Player player, String[] commandArgs) {
        boolean generalView = true;

        if(commandArgs.length > 1){
            generalView = false;
            switch(commandArgs[0]){
                case("grab") -> {
                    System.out.println("Grab Command: ");
                    System.out.println("'grab ' + (specific Item entity)");
                    System.out.println("Takes an Item that is in the room you are in and puts it in your inventory (removes it from the room).");
                }
                case("look") -> {
                    System.out.println("Look Command: ");
                    System.out.println("'look ' + (specific Entity to look at)");
                    System.out.println("Describes a target entity that is in the same room as you");

                    System.out.println("\nThere are some keywords for this command: ");
                    System.out.println("room - current room you are in");
                    System.out.println("self - yourself");
                    System.out.println("inventory - your inventory");
                    System.out.println("exits - shows possible exits of room you are in");
                }
                case("move") -> {
                    System.out.println("Move Command: ");
                    System.out.println("'move ' + (specific direction to move in)");
                    System.out.println("Moves you to another room from the current room you are in a specific direction, provided that it is possible.");
                }
                case("drop") -> {
                    System.out.println("Drop Command: ");
                    System.out.println("'drop ' + (specific Item to drop)");
                    System.out.println("Drops an item from your inventory into the room you are currently in.");
                }
                default -> {
                    System.out.println("Command not recognized, showing general view.");
                    generalView = true;
                }
            }
        }

        if(generalView){
            System.out.println("Possible commands: ");

            System.out.println("help : shows this menu");
            System.out.println("help [command name] : shows detailed info about command");
            System.out.println("grab [target item] : put a target item in the room you are in into your inventory");
            System.out.println("look [target] : look at a target that is in the same room as you");
            System.out.println("move [direction] : move to a different room in a direction from your current room");
            System.out.println("drop [item] : drops an item from your inventory into your current room");
        }
    }
}
