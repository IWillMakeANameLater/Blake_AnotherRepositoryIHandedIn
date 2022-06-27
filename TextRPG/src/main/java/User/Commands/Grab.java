package User.Commands;

import Game.GameData.Entities.Entity;
import Game.GameData.Entities.Item;
import Game.GameData.Entities.Room;
import Game.GameData.Map.GameWorld;
import User.Player;

/**
 * Command that allows player to put items into the inventory.
 */
public class Grab extends Command {

    @Override
    public void run(Player player, String[] commandInputs) {

        String grabTarget = commandInputs[0];
        Entity grabbedEntity = player.getCurrentRoom().retrieveFirst(grabTarget);

        if(grabbedEntity instanceof Item){
            player.showInventory().add(grabbedEntity);
            grabbedEntity.getCurrentRoom().remove(grabbedEntity);
            System.out.println(grabbedEntity.getName() + " was added to " + player.getName() + "'s inventory.");
        } else {
            System.out.println("Entity " + grabTarget + " could not be found or was not an item");
        }
    }

}
