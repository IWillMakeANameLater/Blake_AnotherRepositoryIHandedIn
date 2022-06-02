package Game.GameData.Entities;

import Game.GameData.GeneralInfo.Direction;
import Game.GameData.GameWorld;

import java.util.ArrayList;

public class Room extends Environment {

    private final String roomDesc;

    private final int roomX;
    private final int roomY;


    private ArrayList<Direction> connectedExits;

    public Room(String name, GameWorld world, String roomDesc, int roomX, int roomY){
        super(name, world);
        world.updateMap(this, roomX, roomY);
        this.roomDesc = roomDesc;
        this.roomX = roomX;
        this.roomY = roomY;
        connectedExits = null;
    }

    @Override
    public String observe(){
        String fullDesc = roomDesc;

        for(Entity containedThing:super.getContainedThings()){
            fullDesc += "\n" + containedThing.observe();
        }

        return fullDesc;
    }

    public String goIn(){
        return "You entered " + getName();
    }

    public String checkExits(){
        String allExits = "There are exits in: ";
        if(connectedExits == null){
            for(Direction direction:Direction.values()){
                if(getWorld().isPlaceEmpty(roomX + direction.locationOffsetY, roomY + direction.locationOffsetY)){
                    connectedExits.add(direction);
                }
            }
        }
        for(Direction direction:connectedExits){
            allExits += direction.name() + ", ";
        }
        return allExits;
    }
}
