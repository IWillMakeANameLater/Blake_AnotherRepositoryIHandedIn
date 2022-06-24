package User.Commands;

import User.Player;

public interface Command {
    void run(Player player, String[] commandInputs);
}
