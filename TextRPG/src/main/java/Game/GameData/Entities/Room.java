package Game.GameData.Entities;

import Game.GameData.Enums.Direction;
import Game.GameData.Map.GameWorld;

import java.util.ArrayList;

public class Room extends Container {

    private String roomDesc;

    private int roomX;
    private int roomY;


    private ArrayList<Direction> connectedExits;
    private ArrayList<Entity> containedThings;

    public Room(){
        super();
        this.roomDesc = "";
        this.roomX = 0;
        this.roomY = 0;
        connectedExits = null;
        containedThings = new ArrayList<>();
    }

    @Override
    ArrayList<Entity> getContained() {
        return this.containedThings;
    }

    @Override
    public boolean add(Entity thing) {
        return containedThings.add(thing);
    }

    @Override
    public boolean remove(Entity lookFor) {
        return containedThings.remove(lookFor);
    }

    @Override
    public boolean has(Entity lookFor) {
        return containedThings.contains(lookFor);
    }

    @Override
    public Entity retrieve(int index) {
        return containedThings.get(index);
    }

    @Override
    public Entity retrieveFirst(String name){
        for(Entity containedEntity:containedThings){
            if(containedEntity.getName() == name){
                return containedEntity;
            }
        }
        return null;
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

        fullDesc += "\n The room contains: ";

        for(Entity containedThing:getContained()){
            fullDesc += "\n" + containedThing.observe();
        }

        return fullDesc;
    }

    public ArrayList<Direction> checkExits(){
        if(connectedExits == null){
            connectedExits = new ArrayList<>();
            for(Direction direction:Direction.values()){
                System.out.println(direction);
                System.out.println(getWorld().roomAt(roomX + direction.locationOffsetY, roomY + direction.locationOffsetY));
                if(getWorld().roomAt(roomX + direction.locationOffsetY, roomY + direction.locationOffsetY) != null){
                    connectedExits.add(direction);
                }
            }
        }
        return connectedExits;
    }
}
