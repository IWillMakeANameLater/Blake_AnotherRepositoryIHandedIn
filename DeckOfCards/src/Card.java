public abstract class Card{
    private int value;
    private Suit suit;

    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue(){
        return this.value;
    }

    public Suit getSuit(){
        return this.suit;
    }

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

    @Override
    public String toString(){
        return  this.value + " of " + this.suit.getSuitName();
    }
}
