package User.Commands;

import Game.GameData.Entities.Entity;
import Game.GameData.Enums.Direction;
import Game.GameData.Map.GameWorld;
import User.Player;

import java.util.ArrayList;

/**
 * Command to show the player a description of a specified Entity.
 */
public class Look extends Command{

    @Override
    public void run(Player player, String[] commandInputs) {
        String lookTarget = commandInputs[0];


        switch(lookTarget){
            case("self") -> {
                System.out.println("You are " + player.observe());
            }
            case("inventory") -> {
                System.out.println(player.showInventory().observe());
            }
            case("room") -> {
                System.out.println(player.getCurrentRoom().observe());
            }
            case("exits") -> {
                System.out.println("Possible exits in current room: ");
                ArrayList<Direction> directions = player.getCurrentRoom().checkExits();

                for(Direction direction:directions){
                    System.out.println(direction.name());
                }
            }
            default -> {

                Entity targetEntity = player.getCurrentRoom().retrieveFirst(lookTarget);

                if(targetEntity != null){
                    System.out.println(targetEntity.observe());
                }else{
                    System.out.println("Entity " + lookTarget + " could not be found.");
                }
            }
        }


    }
}
