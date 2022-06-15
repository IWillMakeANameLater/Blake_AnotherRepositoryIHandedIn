package Game.GameData.Entities;

public class Inventory extends Container {

    private Sentient owner;

    public Inventory(Sentient owner){
        super();
        this.owner = owner;
    }

    @Override
    public String observe() {
        return null;
    }
}
