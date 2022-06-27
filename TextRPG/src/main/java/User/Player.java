package User;


import Game.GameData.Entities.Entity;
import Game.GameData.Entities.Item;
import Game.GameData.Entities.Sentient;
import Game.GameData.Enums.Direction;

import java.util.ArrayList;

/**
 * Represents a Sentient entity that the user controls while playing.
 */
public class Player extends Sentient {

    public Player(){
        super();
    }

    @Override
    public String observe(){
        return "you - " + getName();
    }

}
