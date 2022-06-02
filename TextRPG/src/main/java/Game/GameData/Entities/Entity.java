package Game.GameData.Entities;

import Game.GameData.GeneralInfo.GameWorld;

public abstract class Entity {
    private final String name;

    public Entity(String name){
        this.name = name;
    }

    public abstract String observe();

    public String getName(){
        return this.name;
    }

}
