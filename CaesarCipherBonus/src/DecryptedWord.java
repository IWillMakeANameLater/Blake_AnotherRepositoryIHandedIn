import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class DecryptedWord {
    private HashMap<Integer, String> possibleDecryptions;

    public DecryptedWord(String baseWord){
        this.possibleDecryptions = new HashMap<Integer, String>();
        addNewDecryption(null, baseWord);
    }

    public Set<Integer> getPossibleShifts(){
        return possibleDecryptions.keySet();
    }

    public String getStringFromKey(Integer searchKey){
        if(searchKey != null){
            for(Integer key : getPossibleShifts()){
                if(key != null && key.equals(searchKey)){
                    return possibleDecryptions.get(searchKey);
                }
            }
            return null;
        }
        return possibleDecryptions.get(null);
    }


    public boolean hasNoMatches(){
        if(possibleDecryptions.size() == 1 && getStringFromKey(null) != null){
            return true;
        }
        return false;
    }

    public void addNewDecryption(Integer key, String value){
        possibleDecryptions.put(key, value);
    }
}
