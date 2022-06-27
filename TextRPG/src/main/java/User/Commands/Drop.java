package User.Commands;

import Game.GameData.Entities.Item;
import User.Player;

/**
 * Command that allows player to drop items.
 */
public class Drop extends Command {

    @Override
    public void run(Player player, String[] commandArgs) {
        String targetItemName = commandArgs[0];

        Item droppedItem = player.showInventory().retrieveFirst(targetItemName);

        if(droppedItem != null){
            player.showInventory().remove(droppedItem);
            droppedItem.setCurrentRoom(player.getCurrentRoom());
            System.out.println(player.getName() + " dropped " + targetItemName + " in " + player.getCurrentRoom().getName());
        }else{
            System.out.println("Item " + targetItemName + " was not found in " + player.getName() + "'s Inventory");
        }
    }
}
