import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Setting up
        HashSet<Word> uniqueWords =  new HashSet<>();
        Scanner fileScanner = new Scanner(new File("src/illiad.txt"));
        String currentLine = "";

        // Running through the text file and adding the words read into the set
        while(fileScanner.hasNext()){
            currentLine = fileScanner.nextLine();
            String[] currentWords = currentLine.split(" ");
            for(String currentWord : currentWords){
                String baseWord = currentWord.replaceAll("\\W", "");
                if(baseWord.length() > 0){
                    uniqueWords.add(new Word(baseWord));
                }
            }
        }

        // Printing the set and how long it is
        System.out.println(uniqueWords);
        System.out.println(uniqueWords.size());
    }
}
