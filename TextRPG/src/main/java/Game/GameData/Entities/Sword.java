package Game.GameData.Entities;

/**
 * A weapon class.
 */
public class Sword extends Weapon{

    public Sword(){

    }
    @Override
    public String observe() {
        return getName() + " - a sword.";
    }
}
