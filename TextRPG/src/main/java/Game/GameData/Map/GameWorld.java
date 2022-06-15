package Game.GameData.Map;

import Game.GameData.Entities.Entity;
import Game.GameData.Entities.Room;

import java.util.ArrayList;

public class GameWorld {

    private final int worldSize;
    private final String name;

    private final Room[][] worldMap;

    public GameWorld(int worldSize, String name){
        this.worldSize = worldSize;
        this.name = name;
        worldMap = new Room[worldSize][worldSize];
    }

    private boolean withinBoundaries(int X, int Y){
        return (X <= worldSize && X >= 0) && (Y <= worldSize && Y >= 0);
    }


    public Room roomAt(int checkX, int checkY){
        if(withinBoundaries(checkX, checkY)){
            return worldMap[checkX][checkY];
        }
        return null;
    }

    public boolean updateMap(Room roomToAdd, int roomX, int roomY){
        if(withinBoundaries(roomX, roomY)){
            worldMap[roomX][roomY] = roomToAdd;
            return true;
        }else{
            return false;
        }
    }

    public String getName(){
        return this.name;
    }
}
