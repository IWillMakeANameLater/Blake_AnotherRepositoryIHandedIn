import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

class EncryptorTest {
    /*
        Things Encryptor needs to do:
            Create a shifted alphabet
            Encrypt a string
            Decrypt a string

        Limits - Does not support capitals

        Testing:
            1) Can Encryptor create a shifted alphabet properly given a specified shift amount?

            2) Can Encryptor encrypt a message correctly?

            3) can Encryptor decrypt a message properly?

            if encryptor can encrypt, then decrypt a message, while retaining original meaning.
            Since technically, a string it encrypted should also be able to be decrypted by itself.

     */
    @Test
    void ShiftedAlphabetTest(){
        // No offset (0)
        HashMap<Integer, Character> expectedAlphabet = new HashMap<>();
        expectedAlphabet.put(0, 'a');
        expectedAlphabet.put(1, 'b');
        expectedAlphabet.put(2, 'c');
        expectedAlphabet.put(3, 'd');
        expectedAlphabet.put(4, 'e');
        expectedAlphabet.put(5, 'f');
        expectedAlphabet.put(6, 'g');
        expectedAlphabet.put(7, 'h');
        expectedAlphabet.put(8, 'i');
        expectedAlphabet.put(9, 'j');
        expectedAlphabet.put(10, 'k');
        expectedAlphabet.put(11, 'l');
        expectedAlphabet.put(12, 'm');
        expectedAlphabet.put(13, 'n');
        expectedAlphabet.put(14, 'o');
        expectedAlphabet.put(15, 'p');
        expectedAlphabet.put(16, 'q');
        expectedAlphabet.put(17, 'r');
        expectedAlphabet.put(18, 's');
        expectedAlphabet.put(19, 't');
        expectedAlphabet.put(20, 'u');
        expectedAlphabet.put(21, 'v');
        expectedAlphabet.put(22, 'w');
        expectedAlphabet.put(23, 'x');
        expectedAlphabet.put(24, 'y');
        expectedAlphabet.put(25, 'z');

        Encryptor testEncryptor = new Encryptor(0);
        assertEquals(expectedAlphabet, testEncryptor.getEncryptedAlphabet());

        // With an offset of 1 (positive offset)
        HashMap<Integer, Character> expectedAlphabet1 = new HashMap<>();
        expectedAlphabet1.put(0, 'b');
        expectedAlphabet1.put(1, 'c');
        expectedAlphabet1.put(2, 'd');
        expectedAlphabet1.put(3, 'e');
        expectedAlphabet1.put(4, 'f');
        expectedAlphabet1.put(5, 'g');
        expectedAlphabet1.put(6, 'h');
        expectedAlphabet1.put(7, 'i');
        expectedAlphabet1.put(8, 'j');
        expectedAlphabet1.put(9, 'k');
        expectedAlphabet1.put(10, 'l');
        expectedAlphabet1.put(11, 'm');
        expectedAlphabet1.put(12, 'n');
        expectedAlphabet1.put(13, 'o');
        expectedAlphabet1.put(14, 'p');
        expectedAlphabet1.put(15, 'q');
        expectedAlphabet1.put(16, 'r');
        expectedAlphabet1.put(17, 's');
        expectedAlphabet1.put(18, 't');
        expectedAlphabet1.put(19, 'u');
        expectedAlphabet1.put(20, 'v');
        expectedAlphabet1.put(21, 'w');
        expectedAlphabet1.put(22, 'x');
        expectedAlphabet1.put(23, 'y');
        expectedAlphabet1.put(24, 'z');
        expectedAlphabet1.put(25, 'a');

        Encryptor testEncryptor1 = new Encryptor(1);
        assertEquals(expectedAlphabet1, testEncryptor1.getEncryptedAlphabet());

        // With an offset of -1 (negative offset)
        HashMap<Integer, Character> expectedAlphabet2 = new HashMap<>();
        expectedAlphabet2.put(0, 'z');
        expectedAlphabet2.put(1, 'a');
        expectedAlphabet2.put(2, 'b');
        expectedAlphabet2.put(3, 'c');
        expectedAlphabet2.put(4, 'd');
        expectedAlphabet2.put(5, 'e');
        expectedAlphabet2.put(6, 'f');
        expectedAlphabet2.put(7, 'g');
        expectedAlphabet2.put(8, 'h');
        expectedAlphabet2.put(9, 'i');
        expectedAlphabet2.put(10, 'j');
        expectedAlphabet2.put(11, 'k');
        expectedAlphabet2.put(12, 'l');
        expectedAlphabet2.put(13, 'm');
        expectedAlphabet2.put(14, 'n');
        expectedAlphabet2.put(15, 'o');
        expectedAlphabet2.put(16, 'p');
        expectedAlphabet2.put(17, 'q');
        expectedAlphabet2.put(18, 'r');
        expectedAlphabet2.put(19, 's');
        expectedAlphabet2.put(20, 't');
        expectedAlphabet2.put(21, 'u');
        expectedAlphabet2.put(22, 'v');
        expectedAlphabet2.put(23, 'w');
        expectedAlphabet2.put(24, 'x');
        expectedAlphabet2.put(25, 'y');

        Encryptor testEncryptor2 = new Encryptor(-1);
        System.out.println(testEncryptor2.getEncryptedAlphabet());
        assertEquals(expectedAlphabet2, testEncryptor2.getEncryptedAlphabet());
    }

    @Test
    void EncryptionTest(){
        Encryptor testEncryptor = new Encryptor(1);

        // String 1 - single letter
        assertEquals("b", testEncryptor.encryptString("a"));

        // String 2 - Repeated Letters
        assertEquals("bbbbb", testEncryptor.encryptString("aaaaa"));

        // String 3 - Short word
        assertEquals("bqqmf", testEncryptor.encryptString("apple"));

        // String 4 - Several words
        assertEquals("qpubup upnbup cbobob qjofbqqmf fbut", testEncryptor.encryptString("potato tomato banana pineapple eats"));

        // String 5 - non-letters
        assertEquals("9", testEncryptor.encryptString("9"));

        // String 6 - non-letters with letters
        assertEquals("bqqmf.", testEncryptor.encryptString("apple."));
    }

    @Test
    void DecryptionTest(){
        Encryptor testEncryptor = new Encryptor(1);

        // String 1 - single letter
        assertEquals("a", testEncryptor.decryptString("b"));

        // String 2 - Repeated Letters
        assertEquals("aaaaa", testEncryptor.decryptString("bbbbb"));

        // String 3 - Short word
        assertEquals("apple", testEncryptor.decryptString("bqqmf"));

        // String 4 - Several words
        assertEquals("potato tomato banana pineapple eats", testEncryptor.decryptString("qpubup upnbup cbobob qjofbqqmf fbut"));

        // String 5 - non-letters
        assertEquals("9", testEncryptor.decryptString("9"));

        // String 6 - non-letters with letters
        assertEquals("apple.", testEncryptor.decryptString("bqqmf."));
    }
}