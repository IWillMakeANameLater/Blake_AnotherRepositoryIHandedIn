import java.util.Comparator;

/**
 * Compares 2 Cards based on their Value and  <code>Suit</code>. <br>
 *
 * Suits have their own order ( Spades > Hearts > Clubs > Diamonds ) <br>
 *
 * Value is considered after suit, if the suits of the cards are the same
 */

public class SortBySuitAndValue implements Comparator<Card> {


    @Override
    public int compare(Card o1, Card o2) {
        if(o1.getSuit().ordinal() > o2.getSuit().ordinal()){
            return 1;
        } else if (o1.getSuit().ordinal() < o2.getSuit().ordinal()){
            return -1;
        } else {
            if (o1.getValue() > o2.getValue()){
                return -1;
            } else if (o1.getValue() < o2.getValue()){
                return 1;
            } else {
                return 0;
            }
        }
    }
}
