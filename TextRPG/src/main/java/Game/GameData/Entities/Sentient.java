package Game.GameData.Entities;

import Game.GameData.GeneralInfo.GameWorld;

public abstract class Sentient extends Entity{
    private Inventory entityInventory;

    public Sentient(String name){
        super(name);
        entityInventory = new Inventory(getName() + "'s Inventory");
    }
}
