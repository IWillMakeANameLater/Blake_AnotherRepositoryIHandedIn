import java.util.Comparator;

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
