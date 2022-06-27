package User.Commands;

import Game.GameData.Entities.Room;
import Game.GameData.Enums.Direction;
import Game.GameData.Map.GameWorld;
import User.Player;

import java.util.ArrayList;

/**
 * Command that moves the player to another room from their current room with a given direction.
 */
public class Move extends Command{

    @Override
    public void run(Player player, String[] commandInputs) {
        String moveDirection = commandInputs[0];

        Room currentRoom = player.getCurrentRoom();
        GameWorld world = player.getWorld();

        try{
            Direction requestDirection = Direction.valueOf(moveDirection);
            ArrayList<Direction> validDirections = currentRoom.checkExits();
            if(validDirections.contains(requestDirection)){
                player.setCurrentRoom(world.roomAt(currentRoom.getRoomX() + requestDirection.locationOffsetX, currentRoom.getRoomY() + requestDirection.locationOffsetY));
                System.out.println(player.getName() + " moved " + moveDirection + " into " + player.getCurrentRoom().getName());
            }else{
                System.out.println("Can't move in that direction!");
            }
        } catch(IllegalArgumentException e){
            System.out.println("Specified direction doesn't exist");
        }
    }

}
