package Game.GameData.Entities;

public abstract class Weapon extends Item{
    private int Attack;

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }
}
