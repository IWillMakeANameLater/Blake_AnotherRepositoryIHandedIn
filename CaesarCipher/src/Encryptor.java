import java.util.HashMap;
import java.util.Set;

/**
 * A class that can encrypt and decrypt strings a set value.
 * It only encrypts/decrypts alphabet letters. Numbers and symbols will be ignored and retained during encryption and decryption.
 * Any string encrypted by this encryptor, should be able to be decrypted by this encryptor.
 */
public class Encryptor {
    private static HashMap<Integer, Character> baseAlphabet; // Could work as a "if it does not exist, create, otherwise create it"

    private HashMap<Integer, Character> shiftedAlphabet;
    private int shiftValue;

    /**
     * Creates an encryptor with a shifted alphabet based on the offset
     * @param offset # of positions to offset from original alphabet. this can be a negative number.
     */
    public Encryptor(int offset){
        createBaseAlphabet();
        this.shiftValue = offset;
        shiftedAlphabet = new HashMap<>();
        Set<Integer> charValues = baseAlphabet.keySet();
        for(Integer charValue : charValues){
            shiftedAlphabet.put(charValue, shiftedAlpha(charValue));
        }
    }

    /**
     * Gets the shifted alphabet character given a base alphabet character value to shift from
     * Shifts equal to this Encryptor's offset value to ensure uniform shifting from the alphabet
     * @param baseValue the base alphabet character's value to shift from (sourced from base alphabet)
     * @return the new alphabet character that has been shifted
     */
    private char shiftedAlpha(int baseValue){
        int shiftedCharValue = Math.floorMod(baseValue + shiftValue, 26);
        return baseAlphabet.get(shiftedCharValue);
    }


    /**
     * @return the encryptor's shifted alphabet as a HashMap
     */
    public HashMap<Integer, Character> getEncryptedAlphabet(){
        return this.shiftedAlphabet;
    }


    /**
     * @return how many positions the encryptor's alphabet is shifted, relative to normal alphabet as an integer.
     */
    public int getShiftValue(){
        return this.shiftValue;
    }

    /**
     * Encrypts a given string with the encryptor's shifted alphabet. Would require this encryptor or an encryptor with the same offset value to decrypt.
     * @param originalString string to encrypt
     * @return the encrypted string
     */
    public String encryptString(String originalString){
        String newString = "";
        originalString.toLowerCase();
        for(int i = 0; i < originalString.length(); i++){
            char currentChar = originalString.charAt(i);
            if (baseAlphabet.containsValue(currentChar)){ // if it is a letter of the alphabet
                char newChar = shiftedAlphabet.get(((int) currentChar) - ((int) 'a'));
                newString += newChar;
            } else {
                newString += currentChar;
            }
        }
        return newString;
    }

    /**
     * Decrypts a given string, reversing its shift.
     * This would only work if the string was already encrypted by this encryptor or another encryptor that shares the same offset value.
     * @param encryptedString string to decrypt
     * @return the decrypted string
     */
    public String decryptString(String encryptedString){
        String newString = "";
        encryptedString.toLowerCase();
        for(int i = 0; i < encryptedString.length(); i++){
            char currentChar = encryptedString.charAt(i);
            if (baseAlphabet.containsValue(currentChar)){ // Is part of alphabet
                Set<Integer> alphabetKeys = shiftedAlphabet.keySet();
                char newChar = ' ';
                for(Integer key : alphabetKeys){
                    if (shiftedAlphabet.get(key) == currentChar){
                        newChar = baseAlphabet.get(key);
                        break;
                    }
                }
                newString += newChar;
            } else {
                newString += currentChar;
            }
        }
        return newString;
    }

    /**
     * Creates an alphabet with default values (no shifts applied to it)
     */
    private void createBaseAlphabet(){
        if(Encryptor.baseAlphabet == null){
            Encryptor.baseAlphabet = new HashMap<Integer, Character>();
            for(int i = 97; i<123; i++){
                baseAlphabet.put(i-97, (char)i);
            }
        }
    }
}
