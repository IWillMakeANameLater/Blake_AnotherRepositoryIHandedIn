package Game.GameData.Enums;

/**
 * Represents a specific direction that can be moved in the game world.
 */
public enum Direction {
    North(0, -1),
    Northeast(1,-1),
    East(1,0),
    Southeast(1,1),
    South(0,1),
    Southwest(-1,1),
    West(-1,0),
    Northwest(-1,-1);

    public final int locationOffsetX;
    public final int locationOffsetY;

    Direction(int locationOffsetX, int locationOffsetY){
        this.locationOffsetX = locationOffsetX;
        this.locationOffsetY = locationOffsetY;
    }
}
