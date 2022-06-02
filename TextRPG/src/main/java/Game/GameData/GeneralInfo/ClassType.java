package Game.GameData.GeneralInfo;

import Game.GameData.Entities.Room;
import Game.GameData.GameWorld;

public enum ClassType {

    GAMEWORLD("GameWorld", GameWorld.class),
    ROOM("Room", Room.class);

    private final String name;
    private final Class entityClass;

    ClassType(String name, Class entityClass){
        this.name = name;
        this.entityClass = entityClass;
    }
}
