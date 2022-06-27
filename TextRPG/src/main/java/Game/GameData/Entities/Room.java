package Game.GameData.Entities;

import Game.GameData.Enums.Direction;
import Game.GameData.Map.GameWorld;

import java.util.ArrayList;

/**
 * A Container that has a location in the game world.
 * Because of that, can be entered and exited by entities (currently just the player).
 * Can store any kind of Entity in it.
 */
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
            if(containedEntity.getName().equals(name)){
                return containedEntity;
            }
        }
        return null;
    }

    /**
     * @return description of this room
     */
    public String getRoomDesc() {
        return roomDesc;
    }

    /**
     * @param roomDesc description of the room to set to
     */
    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    /**
     * @return gets the X coordinate of this room on the Map
     */
    public int getRoomX() {
        return roomX;
    }

    /**
     * @param roomX X coordinate on the map to set to
     */
    public void setRoomX(int roomX) {
        this.roomX = roomX;
    }

    /**
     * @return Y coordinate of this room on the Map
     */
    public int getRoomY() {
        return roomY;
    }

    /**
     * @param roomY Y coordinate on the map to set to
     */
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
        String fullDesc = getName() + " - " + roomDesc;

        fullDesc += "\n The room contains: ";

        for(Entity containedThing:getContained()){
            fullDesc += "\n" + containedThing.observe();
        }

        return fullDesc;
    }

    /**
     * Checks all connected rooms and returns which exits are possible to move in.
     * If it was not already set, will manually do a check in all directions. Otherwise, returns the stored possible exits from a previous check.
     * @return all possible exits from this room
     */
    public ArrayList<Direction> checkExits(){
        if(connectedExits == null){
            connectedExits = new ArrayList<>();
            for(Direction direction:Direction.values()){
                if(getWorld().roomAt(roomX + direction.locationOffsetX, roomY + direction.locationOffsetY) != null){
                    connectedExits.add(direction);
                }
            }
        }
        return connectedExits;
    }
}
