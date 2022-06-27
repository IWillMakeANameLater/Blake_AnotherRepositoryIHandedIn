package Game.GameData.Map;

import Game.GameData.Entities.Entity;
import Game.GameData.Entities.Room;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents the map of the world.
 * Holds a record of all objects in the world as well as the locations of the rooms.
 * Is separate from 'Entity' as it is not meant to 'contain' another GameWorld.
 */
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


    /**
     * Checks if a room exists on the map at a specific location
     * @param checkX X coordinate to check
     * @param checkY Y coordinate to check
     * @return the room found, or null if none are found
     */
    public Room roomAt(int checkX, int checkY){
        if(withinBoundaries(checkX, checkY)){
            return worldMap[checkX][checkY];
        }
        return null;
    }

    /**
     * adds a room to a specific location on the map
     * @param roomToAdd room to be added
     * @param roomX X coordinate to add to
     * @param roomY Y coordinate to add to
     * @return true if it was successful, or false if it was not
     */
    public boolean updateMap(Room roomToAdd, int roomX, int roomY){
        if(withinBoundaries(roomX, roomY)){
            worldMap[roomX][roomY] = roomToAdd;
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return name of this world
     */
    public String getName(){
        return this.name;
    }

    /**
     * @param entity entity to add to this world
     * @return true if it was successful, or false if it was not
     */
    public boolean addEntity(Entity entity) {
        return worldEntities.add(entity);
    }

    /**
     * @param entity entity to remove from this world
     * @return true if it was successful, or false if it was not
     */
    public boolean removeEntity(Entity entity) {
        return worldEntities.remove(entity);
    }

    /**
     * Searches for an entity in this world by name
     * @param searchName name of entity to search for
     * @return the entity if it was found, or null if it was not
     */
    public Entity findEntity(String searchName){
        for(Entity entity:worldEntities){
            if(entity.getName().equals((searchName))){
                return entity;
            }
        }
        return null;
    }

    /**
     * @return a list of all entities stored in this world
     */
    public ArrayList<Entity> getWorldEntities(){
        return worldEntities;
    }


}
