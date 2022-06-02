package Game.GameData.Entities;

import Game.GameData.GeneralInfo.GameWorld;

import java.util.ArrayList;

public abstract class Environment extends Entity {

    private ArrayList<Entity> containedThings;

    public Environment(String name){
        super(name);
        containedThings = new ArrayList<>();
    }

    public ArrayList<Entity> getContainedThings(){
        return this.containedThings;
    }

    public void addEntity(Entity thing){
        containedThings.add(thing);
    }

    public void removeEntity(Entity lookFor){
        containedThings.remove(lookFor);
    }

    public boolean hasEntity(Entity lookFor){
        return containedThings.contains(lookFor);
    }
}
