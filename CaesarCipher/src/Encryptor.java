import java.util.HashMap;
import java.util.Map;

public class Encryptor {
    private static final HashMap<Character, Integer> baseAlphabet = HashMap.ofEntries();

    private HashMap<Character, Integer> shiftedAlphabet = new HashMap<Character, Integer>();

    public Encryptor(int offset){

    }

    private char shiftedAlpha(int shift){
        return 'a';
    }
}
