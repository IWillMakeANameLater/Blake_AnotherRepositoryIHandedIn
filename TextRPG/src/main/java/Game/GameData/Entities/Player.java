package Game.GameData.Entities;


public class Player extends Sentient {
    public Player(String name){
        super(name);
    }

    @Override
    public String observe(){
        return "";
    }
}
