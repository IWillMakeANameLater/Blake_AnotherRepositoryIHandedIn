package Game.GameData.Entities;

import Game.GameData.GeneralInfo.Direction;
import Game.GameData.GameWorld;

import java.util.ArrayList;

public class Room extends Environment {

    private String roomDesc;

    private int roomX;
    private int roomY;


    private ArrayList<Direction> connectedExits;

    public Room(String name, GameWorld world, String roomDesc, int roomX, int roomY){
        super(name, world);
        world.updateMap(this, roomX, roomY);
        this.roomDesc = roomDesc;
        this.roomX = roomX;
        this.roomY = roomY;
        connectedExits = null;
    }

    public Room(){
        this.roomDesc = "";
        this.roomX = 0;
        this.roomY = 0;
        connectedExits = null;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public int getRoomX() {
        return roomX;
    }

    public void setRoomX(int roomX) {
        this.roomX = roomX;
    }

    public int getRoomY() {
        return roomY;
    }

    public void setRoomY(int roomY) {
        this.roomY = roomY;
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
