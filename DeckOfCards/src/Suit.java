public enum Suit {
    SPADES ("Spades"),
    HEARTS ("Hearts"),
    CLUBS ("Clubs"),
    DIAMONDS ("Diamonds");

    private final String suitName;

    Suit(String suitName){
        this.suitName = suitName;
    }

    public String getSuitName(){
        return this.suitName;
    }

}
