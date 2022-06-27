package User.Commands;

import User.Player;

/**
 * Represents a command that can be done.
 * All commands require the player as well as any following arguments.
 */
public abstract class Command {

    /**
     * Runs the command
     * @param player player that is controlled by the user
     * @param commandArgs any arguments for the command (amount varies)
     */
    public abstract void run(Player player, String[] commandArgs);
}
