import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * Holds the different shift values and the associated shifted word of an encrypted string
 * Has a "null" key that refers to the encrypted string itself, in case there are no possibilities
 * Holds its data in a HashMap
 */
public class DecryptedWord {
    private HashMap<Integer, String> possibleDecryptions;

    /**
     * Creates a new decryptedWord
     * @param baseWord the encrypted version of the word. it is put in the word's HashMap as the value associated with the null key
     */
    public DecryptedWord(String baseWord){
        this.possibleDecryptions = new HashMap<Integer, String>();
        addNewDecryption(null, baseWord);
    }

    /**
     * @return returns all the possible shifts for this word
     */
    public Set<Integer> getPossibleShifts(){
        return possibleDecryptions.keySet();
    }

    /**
     * Given a key, returns the word associated with that key
     * If it doesn't have a word associated with that key, it will return null
     * If the requested key was null, it will return the encrypted version of the word (the null key)
     * @param searchKey the key to find the word with
     * @return String if it finds a valid word, or null if no matches are found
     */
    public String getStringFromKey(Integer searchKey){
        if(!Objects.isNull(searchKey)){
            for(Integer key : getPossibleShifts()){
                if(key != null && key.equals(searchKey)){
                    return possibleDecryptions.get(searchKey);
                }
            }
            return null;
        }
        return possibleDecryptions.get(null);
    }


    /**
     * If the decrypted word only has a single null entry in its HashMap, that means that it does not decrypt to any real word
     * @return whether or not the decrypted word has any real words that it decrypts to
     */
    public boolean hasNoMatches(){
        if(possibleDecryptions.size() == 1 && getStringFromKey(null) != null){
            return true;
        }
        return false;
    }

    /**
     * Adds a new possible shift value and the word it decrypts to in this word's HashMap
     * @param key the shift that would be applied to the word
     * @param value the word that it would decrypt to
     */
    public void addNewDecryption(Integer key, String value){
        possibleDecryptions.put(key, value);
    }
}
