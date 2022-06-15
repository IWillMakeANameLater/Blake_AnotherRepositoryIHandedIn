package Game.GameData.Entities;

import Game.GameData.Map.GameWorld;

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
    }

    public void setCurrentRoom(Room room){
        //Remove from existing room if already in one
        if(currentRoom != null){
            currentRoom.removeEntity(this);
        }

        this.currentRoom = room;
        currentRoom.addEntity(this);
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }
}
