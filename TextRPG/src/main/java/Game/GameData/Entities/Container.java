package Game.GameData.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class that represents any kind of game object that is designed to hold other game objects.
 */
public abstract class Container extends Entity {

    public Container(){
        super();
    }

    /**
     * @return a list of all objects this Container holds
     */
    abstract List getContained();

    /**
     * adds a specified object to this Container
     * @param thing object to add
     * @return true if it succeed or false if it did not
     */
    abstract boolean add(Entity thing);

    /**
     * removes a specified object from this Container
     * @param lookFor object to remove
     * @return true if the removal is successful, or false if it was not (e.g. it did not exist)
     */
    abstract boolean remove(Entity lookFor);

    /**
     * checks if a specified object is contained in this Container
     * @param lookFor object to look for
     * @return true if it does or false if it does not
     */
    abstract boolean has(Entity lookFor);

    /**
     * Returns the object at a specific index in the list of contained objects
     * @param index specific index to retrieve from
     * @return the object at that location
     */
    abstract Entity retrieve(int index);

    /**
     * Retrieves the first stored object that matches the given name
     * @param name name of object to look for
     * @return the found object or null if it's not found
     */
    abstract Entity retrieveFirst(String name);
}
