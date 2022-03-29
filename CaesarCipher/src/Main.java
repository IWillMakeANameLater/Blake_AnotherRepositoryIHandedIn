public class Main {
    public static void main(String[] args) {
        for(int i = 97; i<123; i++){
            System.out.println(i + ", " + (char)i);
        }

        Encryptor test = new Encryptor(10);
        System.out.println(test.getEncryptedAlphabet());
    }
}
