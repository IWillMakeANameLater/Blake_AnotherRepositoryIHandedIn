import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Decryptor test = new Decryptor();

        ArrayList<String> decodedMessages = test.decryptMessage("l dp jrlqj wr sxqfk brx");
        System.out.println(decodedMessages);

        ArrayList<String> decodedMessages2 = test.decryptMessage("dp %421412e1edwaed 12414114124141241412");
        System.out.println(decodedMessages2);
    }
}
