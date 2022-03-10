/**
 * An enum representing a certain face. <br>
 * Each face has a <code>String</code> name and a <code>Int</code> value associated with it.
 */
public enum Face {

    ACE("Ace", 14),
    KING("King", 13),
    QUEEN("Queen", 12),
    JACK("Jack", 11);

    private final String faceName;
    private final int value;

    /**
     * Creates a face enum
     * Each face has a value tied to it as well
     * @param faceName - name of the Face
     * @param value - the value tied to the face
     */
    Face(String faceName, int value ){
        this.faceName = faceName;
        this.value = value;
    }

    /**
     * @return the name of this face
     */
    public String getFaceName(){
        return this.faceName;
    }

    /**
     * @return the value associated with this face
     */
    public int getValue(){
        return this.value;
    }
}
