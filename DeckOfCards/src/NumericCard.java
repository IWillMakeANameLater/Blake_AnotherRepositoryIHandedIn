/**
 * A card with a numeric value and a <code>Suit</code>. <br>
 * It acts the same as a numeric card. It's just not abstract.
 */
public class NumericCard extends Card{

    /**
     * A constructor for a numeric card, it is the same as the one for the abstract class Card
     * @param value - Value of the card
     * @param suit - The suit the card belongs to
     */
    public NumericCard(int value, Suit suit){
        super(value, suit);
    }
}
