package Game.GameData.Entities;

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

    public Inventory showInventory(){
        return entityInventory;
    }
}
