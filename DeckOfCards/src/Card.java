/**
 * An abstract class that represents a card, with a value and a <code>Suit</code>. <br>
 * Holds a lot of the methods used by child card types. <br>
 * Is the base foundation that the other cards build on.
 */
public abstract class Card{
    private int value;
    private Suit suit;

    /**
     * A constructor for the abstract class Card
     * @param value - value of the card
     * @param suit - the suit the card belongs to
     */
    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    /**
     * @return the value of the card
     */
    public int getValue(){
        return this.value;
    }

    /**
     * @return the suit of the card
     */
    public Suit getSuit(){
        return this.suit;
    }

    /**
     * Compares this Card with another object.
     * If it is a card, this will compare their suit and value to determine if they are the same
     * @param compareTo - the object to be compared to
     * @return if it is equal to the object or not
     */
    @Override
    public boolean equals(Object compareTo){
        boolean isEqual = false;
        if(compareTo instanceof Card){
            Card comparedCard = (Card) compareTo;
            if(comparedCard.getSuit() == this.suit && comparedCard.getValue() == this.value){
                isEqual = true;
            }
        }
        return isEqual;
    }

    /**
     * Transforms this card into a string
     * @return a string describing this Card
     */
    @Override
    public String toString(){
        return  this.value + " of " + this.suit.getSuitName();
    }
}
