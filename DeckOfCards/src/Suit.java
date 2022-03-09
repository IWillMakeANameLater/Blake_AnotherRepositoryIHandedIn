public enum Suit {
    SPADES ("Spades"),
    HEARTS ("Hearts"),
    CLUBS ("Clubs"),
    DIAMONDS ("Diamonds");

    private final String suitName;

    /**
     * Creates a Suit enum
     * @param suitName - the name of the suit
     */
    Suit(String suitName){
        this.suitName = suitName;
    }

    /**
     * @return the name of this suit
     */
    public String getSuitName(){
        return this.suitName;
    }

}
