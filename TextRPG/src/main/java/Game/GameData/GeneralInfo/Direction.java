package Game.GameData.GeneralInfo;

public enum Direction {
    NORTH(0, 1),
    NORTHEAST(1,1),
    EAST(1,0),
    SOUTHEAST(1,-1),
    SOUTH(0,-1),
    SOUTHWEST(-1,-1),
    WEST(-1,0),
    NORTHWEST(-1,1);

    public final int locationOffsetX;
    public final int locationOffsetY;

    Direction(int locationOffsetX, int locationOffsetY){
        this.locationOffsetX = locationOffsetX;
        this.locationOffsetY = locationOffsetY;
    }
}
