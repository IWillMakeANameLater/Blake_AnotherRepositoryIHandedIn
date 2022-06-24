package User.Commands;

import Game.GameData.Enums.Direction;
import User.Player;

public class Move implements Command{

    @Override
    public void run(Player player, String[] commandInputs) {
        String moveDirection = commandInputs[0];

        player.Move(Direction.valueOf(moveDirection));
    }

}
