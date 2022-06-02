package Game.GameData;

import Game.GameData.Entities.Entity;
import Game.GameData.Entities.Room;

import java.util.ArrayList;

public class GameWorld {

    private final int worldSize;
    private final String name;

    private Room[][] worldMap;
    private ArrayList<Entity> worldEntities;

    public GameWorld(int worldSize, String name){
        this.worldSize = worldSize;
        this.name = name;
        worldMap = new Room[worldSize][worldSize];
        worldEntities = new ArrayList<>();
    }

    private boolean withinBoundaries(int X, int Y){
        return (X <= worldSize && X >= 0) && (Y <= worldSize && Y >= 0);
    }

    public boolean updateMap(Room roomToAdd, int roomX, int roomY){
        if(withinBoundaries(roomX, roomY)){
            worldMap[roomX][roomY] = roomToAdd;
            return true;
        }else{
            return false;
        }
    }

    public void addEntity(Entity entity){
        worldEntities.add(entity);
    }

    public boolean hasEntity(Entity entity){
        return worldEntities.contains(entity);
    }

    public boolean isPlaceEmpty(int checkX, int checkY){
        if(withinBoundaries(checkX, checkY)){
            return worldMap[checkX][checkY] != null;
        }
        return true;
    }

    public String getName(){
        return this.name;
    }
}
