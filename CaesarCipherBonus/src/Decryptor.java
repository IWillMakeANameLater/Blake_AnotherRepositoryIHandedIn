import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Decryptor {
    static private ArrayList<ArrayList<String>> WORD_LENGTHS = new ArrayList<ArrayList<String>>();

    static {
        for(int i = 0; i < 100; i++){
            WORD_LENGTHS.add(new ArrayList<String>());
        }
        try {
            FileReader baseReader = new FileReader("src/words_alpha.txt");
            BufferedReader wordTextReader = new BufferedReader(baseReader);
            String currentWord;
            while ((currentWord = wordTextReader.readLine()) != null){
                ArrayList<String> matchingLengthSection = WORD_LENGTHS.get(currentWord.length()-1);
                matchingLengthSection.add(currentWord);
            }
            wordTextReader.close();
        } catch (IOException ignored) {}
    }

    public static ArrayList<ArrayList<String>> getWordLengths(){
        return WORD_LENGTHS;
    }

    public Decryptor(){

    }

    public ArrayList<String> decryptMessage(String encryptedMessage){
        encryptedMessage = encryptedMessage.toLowerCase();
        String[] encryptedWords = encryptedMessage.split(" ");
        ArrayList<HashMap<Integer, String>> possibleDecryptedWords = new ArrayList<>();
        HashSet<Integer> possibleShifts = new HashSet<>();
        for(String word : encryptedWords){
            HashMap<Integer, String> decryptedWord = decryptWord(word);
            for(Integer shift : decryptedWord.keySet()){
                if(shift != null){
                    possibleShifts.add(shift);
                }
            }
            possibleDecryptedWords.add(decryptedWord);
        }
        HashSet<Integer> correctShifts = new HashSet<>();
        testPotentialShifts: for(Integer shift : possibleShifts){
            for(HashMap<Integer, String> decryptedWord : possibleDecryptedWords){
                if(decryptedWord.get(null) == null && decryptedWord.get(shift) == null){
                    continue testPotentialShifts; // if one word doesn't match, skip over this shift
                }
            }
            correctShifts.add(shift); // there may be more
        }
        ArrayList<String> possibleDecryptedMessages = new ArrayList<>();
        for(Integer correctShift : correctShifts){
            String fullMessage = "";
            for(HashMap<Integer, String> decryptedWord : possibleDecryptedWords){
                String word = "";
                if(decryptedWord.containsKey(correctShift)){
                    word = decryptedWord.get(correctShift);
                } else {
                    word = decryptedWord.get(null);
                }
                fullMessage += word + " ";
            }
            possibleDecryptedMessages.add(fullMessage);
        }
        return possibleDecryptedMessages;
    }

    public HashMap<Integer, String> decryptWord(String word){
        HashMap<Integer, String> decryptedWord = new HashMap<>();
        ArrayList<String> wordLengthSection = WORD_LENGTHS.get(word.length()-1);
        for(String potentialMatch : wordLengthSection){
            Integer offset = compareWordLetterOffsets(word, potentialMatch);
            if(offset != null){
                decryptedWord.put(offset, potentialMatch);
            }
        }
        if(decryptedWord.size() == 0){ // word has no matches found
            decryptedWord.put(null, word); // a 'null' entry to show that there are no existing matches, only situation where a null key would exist is if there are no matching words
        }
        return decryptedWord;
    }

    public Integer compareWordLetterOffsets(String word1, String word2){
        Integer offset = null;
        Integer inverseOffset = null;
        for(int i = 0; i < word1.length(); i++){
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);
            if(offset == null){
                offset = Math.abs(char2-char1);
                inverseOffset = 26-offset;
            } else{
                Integer newOffset = Math.abs(char2-char1);
                Integer newInverseOffset = 26-newOffset;
            }
        }
        return offset;
    }
}
