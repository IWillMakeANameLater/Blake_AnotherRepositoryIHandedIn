public class NumericCard extends Card{

    /**
     * A constructor for a numeric card
     * It is the same as the constructor for the Card abstract class, as the numeric card has no difference functionally from the card
     * @param value - Value of the card
     * @param suit - The suit the card belongs to
     */
    public NumericCard(int value, Suit suit){
        super(value, suit);
    }
}
