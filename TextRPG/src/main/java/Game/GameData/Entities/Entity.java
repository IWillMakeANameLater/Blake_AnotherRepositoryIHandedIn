package Game.GameData.Entities;

import Game.GameData.GameWorld;

public abstract class Entity {
    private String name;

    private GameWorld world;

    public Entity(String name, GameWorld world){
        this.name = name;
        this.world = world;
        world.addEntity(this);
    }

    public Entity(){
        this.name = "";
        this.world = null;
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
}
