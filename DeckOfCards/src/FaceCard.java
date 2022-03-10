/**
 * A card with a face and a <code>Suit</code>. <br>
 * Internally, the card does still have a value with it. <br>
 * Functions similarly to a Card but compares with face instead of value.
 */
public class FaceCard extends Card{

    private Face face;

    /**
     * Creates a new face card given a face and a suit
     * @param face - the face of the Face card
     * @param suit - the suit the card belongs to
     */
    public FaceCard(Face face, Suit suit){
        super(face.getValue(), suit);
        this.face = face;
    }

    /**
     * @return the face of the card
     */
    public Face getFace(){
        return this.face;
    }

    /**
     * Compares this Face card to another object
     * Is simillar to Card abstract class' equals method, but compares with Face instead of value
     * @param compareTo - the object to be compared to
     * @return if they are the same or not
     */
    @Override
    public boolean equals(Object compareTo){
        boolean isEqual = false;
        if(compareTo instanceof FaceCard){
            FaceCard comparedFaceCard = (FaceCard) compareTo;
            if(comparedFaceCard.getFace() == this.face && comparedFaceCard.getSuit() == this.getSuit()){
                isEqual = true;
            }
        }
        return isEqual;
    }

    /**
     * @return a string describing this face card
     */
    @Override
    public String toString(){
        return this.face.getFaceName() + " of " + this.getSuit().getSuitName();
    }
}
