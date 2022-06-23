package User;


import Game.GameData.Entities.Sentient;
import Game.GameData.Enums.Direction;

import java.util.ArrayList;

public class Player extends Sentient {

    public Player(){
        super();
    }

    @Override
    public String observe(){
        return "";
    }

    public void Move(Direction requestDirection){
        ArrayList<Direction> validDirections = getCurrentRoom().checkExits();
        if(validDirections.contains(requestDirection)){
            setCurrentRoom(getWorld().roomAt(getCurrentRoom().getRoomX() + requestDirection.locationOffsetX, getCurrentRoom().getRoomY() + requestDirection.locationOffsetY));
        }
    }
}
