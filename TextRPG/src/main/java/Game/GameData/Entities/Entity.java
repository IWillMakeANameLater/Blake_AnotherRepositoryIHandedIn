package Game.GameData.Entities;

import Game.GameData.Map.GameWorld;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    public abstract String observe();

    public String getName(){
        return this.name;
    }

    public GameWorld getWorld() {
        return this.world;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setWorld(GameWorld world){
        this.world = world;
        world.addEntity(this);
    }

    public void setCurrentRoom(Room room){
        //Remove from existing room if already in one
        if(currentRoom != null){
            currentRoom.remove(this);
        }

        this.currentRoom = room;
        currentRoom.add(this);
    }

    public void setCurrentRoom(String roomName){
        Room foundRoom = (Room) world.findEntity(roomName);
        setCurrentRoom(foundRoom);
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }
}
