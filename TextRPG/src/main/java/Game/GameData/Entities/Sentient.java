package Game.GameData.Entities;

import Game.GameData.GameWorld;

public abstract class Sentient extends Entity{
    private Inventory entityInventory;

    public Sentient(String name, GameWorld world){
        super(name, world);
    }
}
