package Game.GameData.Entities;

public abstract class Sentient extends Entity{
    private Inventory entityInventory;

    //Stats

    public Sentient(){
        super();
        entityInventory = new Inventory(this);
    }


}
