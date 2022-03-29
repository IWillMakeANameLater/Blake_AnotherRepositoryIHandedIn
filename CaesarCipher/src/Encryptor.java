import java.util.HashMap;
import java.util.Set;

public class Encryptor {
    private static HashMap<Integer, Character> baseAlphabet; // Could work as a "if it does not exist, create, otherwise create it"

    private HashMap<Integer, Character> shiftedAlphabet;
    private int shiftValue;

    public Encryptor(int offset){
        createBaseAlphabet();
        this.shiftValue = offset;
        shiftedAlphabet = new HashMap<>();
        Set<Integer> charValues = baseAlphabet.keySet();
        for(Integer charValue : charValues){
            shiftedAlphabet.put(charValue, shiftedAlpha(charValue));
        }
    }

    private char shiftedAlpha(int baseValue){
        int shiftedCharValue = Math.floorMod(baseValue + shiftValue, 26);
        return baseAlphabet.get(shiftedCharValue);
    }

    public HashMap<Integer, Character> getEncryptedAlphabet(){
        return this.shiftedAlphabet;
    }

    public int getShiftValue(){
        return this.shiftValue;
    }

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

    public String decryptString(String encryptedString){
        String newString = "";
        encryptedString.toLowerCase();
        for(int i = 0; i < encryptedString.length(); i++){
            char currentChar = encryptedString.charAt(i);
            if (baseAlphabet.containsValue(currentChar)){ // Is part of alphabet
                Set<Integer> alphabetKeys = shiftedAlphabet.keySet();

                for(Integer keys : alphabetKeys){
                        
                }

                newString += newChar;
            } else {
                newString += currentChar;
            }
        }
        return newString;
    }

    private void createBaseAlphabet(){
        if(Encryptor.baseAlphabet == null){
            Encryptor.baseAlphabet = new HashMap<Integer, Character>();
            for(int i = 97; i<123; i++){
                baseAlphabet.put(i-97, (char)i);
            }
        }
    }
}
