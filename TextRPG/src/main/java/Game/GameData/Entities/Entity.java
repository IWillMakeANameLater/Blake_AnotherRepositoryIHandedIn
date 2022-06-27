package Game.GameData.Entities;

import Game.GameData.Map.GameWorld;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Base class that represents all game objects.
 */
@JsonIgnoreProperties(value = { "currentRoom" })
public abstract class Entity {

    //Initiated Data
    private String name;
    private GameWorld world;

    private Room currentRoom;

    public Entity(){
        this.name = "";
        this.world = null;
        this.currentRoom = null;
    }

    /**
     * @return description of this Entity
     */
    public abstract String observe();

    /**
     * @return name of this entity
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return the world that holds this entity
     */
    public GameWorld getWorld() {
        return this.world;
    }

    /**
     * Sets the name of this entity
     * @param name name to set to
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the world that this entity is contained in
     * Also adds itself to the list of entities stored by the world
     * @param world world to add itself to
     */
    public void setWorld(GameWorld world){
        this.world = world;
        world.addEntity(this);
    }

    /**
     * Sets the room that this entity is located in
     * If it was already in a room, it will remove itself from the previous room and add itself to the new room
     * @param room room to add itself to
     */
    public void setCurrentRoom(Room room){
        //Remove from existing room if already in one
        if(currentRoom != null){
            currentRoom.remove(this);
        }

        this.currentRoom = room;
        currentRoom.add(this);
    }

    /**
     * Same as setCurrentRoom(Room) but will search the world this entity is stored in for that room
     * @param roomName name of room to add itself to
     */
    public void setCurrentRoom(String roomName){
        Room foundRoom = (Room) world.findEntity(roomName);
        setCurrentRoom(foundRoom);
    }

    /**
     *
     * @return gets the current room that stores this entity
     */
    public Room getCurrentRoom(){
        return currentRoom;
    }
}
