import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    /*
        Testing: This test looks to make sure that the Word object is properly recognizing similar strings as the same word.

        Example of Expected Behavior:
        Word "house"
        If in a piece of literature, variations such as "House", "house!", ' "house" ', "house?" show up,
        they should be considered the same word as "house".

        Testing for: Correctly recognizing a word in different forms
        Common types of variations: Surrounding quotes, punctations at end of word, Capitlization of the first letter. Sometimes a combination of several of these.
     */

    @Test
    void wordTest(){
        // Word 1
        Word word1 = new Word("Home");
        String[] variations1 = {"Home!", "home", "hOmE", "home.", "\"home\"", "home.\"", "home?", "Home.", "Home?"};
        for( String variation : variations1){
            assertTrue(word1.stringIsWord(variation));
        }

        // Word 2
        Word word2 = new Word("Apple");

        String[] variations2 = {"apple", "Apple!", "Apple?", "Apple.", "aPPle", "\"apple\"", "apple.\""};
        for( String variation : variations2) {
            assertTrue(word2.stringIsWord(variation));
        }

        // Word 3
        Word word3 = new Word("Computer");
        String[] variations3 = {"computer.", "computer?", "Computer.", "comPUTER", "\"Computer\"", "Computer.\"", "Computer", "Computer..." };
        for (String variation : variations3){
            assertTrue(word3.stringIsWord(variation));
        }

        assertFalse(word3.stringIsWord("Computers"));
        assertFalse(word3.stringIsWord("Computher"));
        assertFalse(word3.stringIsWord("Your Mother"));
        assertFalse(word3.stringIsWord("Computer Engineer"));
    }
}