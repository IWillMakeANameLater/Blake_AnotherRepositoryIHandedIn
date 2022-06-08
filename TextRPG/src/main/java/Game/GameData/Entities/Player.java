package Game.GameData.Entities;


import Game.GameData.GameWorld;

public class Player extends Sentient {
    public Player(String name, GameWorld world){
        super(name, world);
    }

    @Override
    public String observe(){
        return "";
    }
}
