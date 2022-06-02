package Game.GameData.GeneralInfo;

import Game.GameData.Entities.Room;

public class GameWorld {
    private static final int WORLDSIZE = 1000;

    private Room[][] WorldMap;

    public GameWorld(){
        WorldMap = new Room[WORLDSIZE][WORLDSIZE];
    }

    private boolean withinBoundaries(int X, int Y){
        return (X <= WORLDSIZE && X >= 0) && (Y <= WORLDSIZE && Y >= 0);
    }

    public boolean updateMap(Room roomToAdd, int roomX, int roomY){
        if(withinBoundaries(roomX, roomY)){
            WorldMap[roomX][roomY] = roomToAdd;
            return true;
        }else{
            return false;
        }
    }

    public boolean isPlaceEmpty(int checkX, int checkY){
        if(withinBoundaries(checkX, checkY)){
            return WorldMap[checkX][checkY] != null;
        }
        return true;
    }
}
