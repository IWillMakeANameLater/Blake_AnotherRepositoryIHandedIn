public enum Face {

    ACE("Ace", 14),
    KING("King", 13),
    QUEEN("Queen", 12),
    JACK("Jack", 11);

    private final String faceName;
    private final int value;

    Face(String faceName, int value ){
        this.faceName = faceName;
        this.value = value;
    }

    public String getFaceName(){
        return this.faceName;
    }

    public int getValue(){
        return this.value;
    }
}
