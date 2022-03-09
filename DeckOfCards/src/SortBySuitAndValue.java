import java.util.Comparator;

public class SortBySuitAndValue implements Comparator<Card> {

    /**
     * Compares 2 Cards based on their Value and Suit
     * Suits have their own order ( Spades > Hearts > Clubs > Diamonds )
     * @param o1 - first Card to compare
     * @param o2 - second Card to compare
     * @return -1 if o2 is bigger, 1 if o1 is bigger, or 0 if they are the same
     */
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
