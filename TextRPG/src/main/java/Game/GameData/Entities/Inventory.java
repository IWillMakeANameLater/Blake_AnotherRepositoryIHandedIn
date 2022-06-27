package Game.GameData.Entities;

import java.util.ArrayList;

/**
 * A Container that can only hold Items in particular.
 * Unlike room, does not have a specified location in the game world, and is tied to a Sentient Entity instead.
 */
public class Inventory extends Container {

    private Sentient owner;

    private ArrayList<Item> containedItems;

    public Inventory(Sentient owner){
        super();
        this.owner = owner;
        this.containedItems = new ArrayList<>();
    }

    @Override
    public ArrayList<Item> getContained() {
        return containedItems;
    }

    @Override
    public boolean add(Entity thing) {
        if(thing instanceof Item){
            containedItems.add((Item) thing);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Entity lookFor) {
        return containedItems.remove(lookFor);
    }

    @Override
    public boolean has(Entity lookFor) {
        return containedItems.contains(lookFor);
    }

    @Override
    public Item retrieve(int index){
        return containedItems.get(index);
    }

    @Override
    public Item retrieveFirst(String name){
        for(Item containedItem:containedItems){
            if(containedItem.getName().equals(name)){
                return containedItem;
            }
        }
        return null;
    }

    @Override
    public String observe() {
        String fullDesc = owner.getName() + "'s inventory. It has: ";

        for(Item containedItem:containedItems){
            fullDesc += containedItem.observe();
        }

        return fullDesc;
    }
}
