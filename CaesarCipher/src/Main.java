public class Main {
    public static void main(String[] args) {
        Encryptor test = new Encryptor(1);

        String encryptedString = test.encryptString("apple");
        System.out.println(encryptedString);

        String decrypedString = test.decryptString(encryptedString);
        System.out.println(decrypedString);
    }
}
