package Game.GameData.Entities;

import Game.GameData.GameWorld;

public abstract class Inventory extends Environment{

    public Inventory(String name, GameWorld world){
        super(name, world);
    }

    @Override
    public String observe() {
        return null;
    }
}
