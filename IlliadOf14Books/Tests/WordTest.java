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
        Special Case: the word exists within a large composite word -> should still be considered seperate words

        Test for both raw string and Word object comparisons
     */

    @Test
    void wordTest(){
        // Word 1 - String
        Word word1 = new Word("Home");
        String[] variations1 = {"Home!", "home", "hOmE", "home.", "\"home\"", "home.\"", "home?", "Home.", "Home?"};
        for( String variation : variations1){
            assertTrue(word1.stringIsWord(variation));
        }

        // Word 2 - String
        Word word2 = new Word("Apple");

        String[] variations2 = {"apple", "Apple!", "Apple?", "Apple.", "aPPle", "\"apple\"", "apple.\""};
        for( String variation : variations2) {
            assertTrue(word2.stringIsWord(variation));
        }

        // Word 3 - String
        Word word3 = new Word("Computer");
        String[] variations3 = {"computer.", "computer?", "Computer.", "comPUTER", "\"Computer\"", "Computer.\"", "Computer", "Computer..." };
        for (String variation : variations3){
            assertTrue(word3.stringIsWord(variation));
        }

        // Word 3 - Different, Similar and Composite Words ( String )
        assertFalse(word3.stringIsWord("Computers"));
        assertFalse(word3.stringIsWord("Computher"));
        assertFalse(word3.stringIsWord("Your Mother"));
        assertFalse(word3.stringIsWord("Computer Engineer"));

        // Word 2 - Comparisons with other Word objects
        assertNotEquals(word2, (new Word("Banana")));
        assertEquals(word2, (new Word("Apple")));
        assertNotEquals(word2, (new Word("Apples")));
    }
}