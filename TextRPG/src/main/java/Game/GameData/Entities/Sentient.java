package Game.GameData.Entities;

/**
 * An Entity that is characterized by possessing an Inventory (and in the future, stats).
 * As well as the ability to do stuff such as entering/exiting rooms and attacking (currently, only Player is an actual class that extends from this).
 */
public abstract class Sentient extends Entity{
    private Inventory entityInventory;

    //Stats

    public Sentient(){
        super();
        entityInventory = new Inventory(this);
    }

    @Override
    public void setName(String name){
        super.setName(name);
        entityInventory.setName(name + "_Inventory");
    }

    /**
     * @return Gets the inventory of this Sentient
     */
    public Inventory showInventory(){
        return entityInventory;
    }
}
