package Game.GameData.Entities;

import Game.GameData.Enums.Direction;
import Game.GameData.Map.GameWorld;

import java.util.ArrayList;

public class Room extends Container {

    private String roomDesc;

    private int roomX;
    private int roomY;


    private ArrayList<Direction> connectedExits;

    public Room(){
        super();
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
    public void setWorld(GameWorld world){
        super.setWorld(world);
        world.updateMap(this, this.roomX, this.roomY);
    }

    @Override
    public String observe(){
        String fullDesc = roomDesc;

        for(Entity containedThing:super.getContainedThings()){
            fullDesc += "\n" + containedThing.observe();
        }

        return fullDesc;
    }

    public String checkExits(){
        String allExits = "There are exits in: ";
        if(connectedExits == null){
            for(Direction direction:Direction.values()){
                if(getWorld().roomAt(roomX + direction.locationOffsetY, roomY + direction.locationOffsetY) != null){
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
