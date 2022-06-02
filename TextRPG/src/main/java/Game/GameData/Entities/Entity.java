package Game.GameData.Entities;

import Game.GameData.GameWorld;

public abstract class Entity {
    private final String name;

    private GameWorld world;

    public Entity(String name, GameWorld world){
        this.name = name;
        this.world = world;
        world.addEntity(this);
    }

    public abstract String observe();

    public String getName(){
        return this.name;
    }

    public GameWorld getWorld() {
        return this.world;
    }

}
