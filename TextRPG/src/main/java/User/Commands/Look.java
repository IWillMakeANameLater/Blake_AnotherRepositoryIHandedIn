package User.Commands;

import Game.GameData.Entities.Entity;
import Game.GameData.Map.GameWorld;
import User.Player;

public class Look implements Command{

    @Override
    public void run(Player player, String[] commandInputs) {
        String lookTarget = commandInputs[0];

        GameWorld currentWorld = player.getWorld();

        Entity targetEntity = currentWorld.findEntity(lookTarget);

        if(targetEntity != null){
            System.out.println(targetEntity.observe());
        }
    }
}
