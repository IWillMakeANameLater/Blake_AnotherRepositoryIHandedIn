package User.Commands;

import Game.GameData.Entities.Entity;
import Game.GameData.Entities.Item;
import Game.GameData.Entities.Room;
import Game.GameData.Map.GameWorld;
import User.Player;

public class Grab implements Command {

    @Override
    public void run(Player player, String[] commandInputs) {
        GameWorld currentWorld = player.getWorld();

        String grabTarget = commandInputs[0];
        Entity grabbedEntity = currentWorld.findEntity(grabTarget);

        if(grabbedEntity instanceof Item){
            player.showInventory().add(grabbedEntity);
            grabbedEntity.setCurrentRoom((Room) null);
        }
    }

}
