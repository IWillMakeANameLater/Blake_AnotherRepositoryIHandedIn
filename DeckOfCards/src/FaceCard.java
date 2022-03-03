public class FaceCard extends Card{

    private Face face;

    public FaceCard(Face face, Suit suit){
        super(face.getValue(), suit);
        this.face = face;
    }

    public Face getFace(){
        return this.face;
    }

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

    @Override
    public String toString(){
        return this.face.getFaceName() + " of " + this.getSuit().getSuitName();
    }
}
