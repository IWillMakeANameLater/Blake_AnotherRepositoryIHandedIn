package Game.GameData.Map;

import Game.GameData.Entities.Entity;
import Game.GameData.Entities.Room;

import java.util.ArrayList;
import java.util.Objects;

public class GameWorld {

    private final int worldSize;
    private final String name;

    private final Room[][] worldMap;

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

    public boolean addEntity(Entity entity) {
        return worldEntities.add(entity);
    }

    public boolean removeEntity(Entity entity) {
        return worldEntities.remove(entity);
    }

    public Entity findEntity(String searchName){
        for(Entity entity:worldEntities){
            if(entity.getName().equals((searchName))){
                return entity;
            }
        }
        return null;
    }

    public ArrayList<Entity> getWorldEntities(){
        return worldEntities;
    }


}
