package Game.GameData.Entities;

/**
 * A specific type of Item that has offensive combat stats (combat not implemented).
 * Would extend from 'Equipment' abstract class, which would represent Items that can be equipped.
 * But that wasn't implemented either.
 */
public abstract class Weapon extends Item{
    private int Attack;

    /**
     * @return gets the Attack stat of this weapon
     */
    public int getAttack() {
        return Attack;
    }

    /**
     * @param attack attack stat to set to for this weapon
     */
    public void setAttack(int attack) {
        Attack = attack;
    }
}
