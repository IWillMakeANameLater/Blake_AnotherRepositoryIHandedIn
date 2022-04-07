import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Decryptor test = new Decryptor();

        System.out.println(test.compareWordLetterOffsets("brx", "you"));
        System.out.println(test.decryptWord("brx"));

        ArrayList<String> decodedMessages = test.decryptMessage("l dp jrlqj wr sxqfk brx");
        System.out.println(decodedMessages);
    }
}
