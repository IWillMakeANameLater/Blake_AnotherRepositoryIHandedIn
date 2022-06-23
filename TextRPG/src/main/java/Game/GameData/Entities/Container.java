package Game.GameData.Entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Container extends Entity {

    public Container(){
        super();
    }

    abstract List getContained();

    abstract boolean add(Entity thing);

    abstract boolean remove(Entity lookFor);

    abstract boolean has(Entity lookFor);

    abstract Entity retrieve(int index);

    abstract Entity retrieveFirst(String name);
}
