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

    public ArrayList<String> decryptMessage(String baseMessage){
        String lowerCaseMessage = baseMessage.toLowerCase();
        String encryptedMessage = lowerCaseMessage.replaceAll("[^a-zA-Z ]", "");

        String[] encryptedWords = encryptedMessage.split(" ");
        ArrayList<DecryptedWord> possibleDecryptedWords = new ArrayList<>();
        HashSet<Integer> possibleShifts = new HashSet<>();
        ArrayList<String> possibleDecryptedMessages = new ArrayList<>();

        for(String word : encryptedWords){
            DecryptedWord decryptedWord = decryptWord(word);
            for(Integer key : decryptedWord.getPossibleShifts()){
                if(key != null){
                    possibleShifts.add(key);
                }
            }
            possibleDecryptedWords.add(decryptedWord);
        }

        tryAllFoundShifts: for(Integer shift : possibleShifts){
            String fullMessage = "";
            for(DecryptedWord decryptedWord : possibleDecryptedWords){
                String shiftedString = decryptedWord.getStringFromKey(shift);
                boolean hasNoMatches = decryptedWord.hasNoMatches();
                String word = "";
                if(shiftedString == null){
                    if(!hasNoMatches){
                        continue tryAllFoundShifts;
                    }
                    word = decryptedWord.getStringFromKey(null);
                } else {
                    word = shiftedString;
                }
                fullMessage += shiftedString + " ";
            }
            possibleDecryptedMessages.add(fullMessage);
        }
        return possibleDecryptedMessages;
    }

    public DecryptedWord decryptWord(String word){
        DecryptedWord decryptedWord = new DecryptedWord(word);
        ArrayList<String> wordLengthSection = WORD_LENGTHS.get(word.length()-1);
        for(String potentialMatch : wordLengthSection){
            Integer offset = compareWordLetterOffsets(word, potentialMatch);
            if(offset != null){
                decryptedWord.addNewDecryption(offset, potentialMatch);
            }
        }
        return decryptedWord;
    }

    public Integer compareWordLetterOffsets(String word1, String word2){
        Integer offset = null;
        for(int i = 0; i < word1.length(); i++){
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);
            if(offset == null){
                offset = Math.floorMod(char2-char1, 26);
            } else if (Math.floorMod(char2-char1, 26) != offset){
                offset = null;
                return offset;
            }
        }
        return offset;
    }
}
