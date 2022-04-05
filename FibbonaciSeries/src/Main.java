import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(fibboSum(3));
    }

    /**
     * Gets the number at a specific position of the fibbonaci sequence
     * @param pos the specific position of the number
     * @return the number at that position in the fibbonaci sequence
     */
    private static Integer fibboStep(int pos){
        if(pos <= 2){
            return 1;
        }
        return fibboStep(pos - 1) + fibboStep(pos - 2);
    }

    /**
     * gets the sum of the fibonnaci sequence up the specified length
     * @param length the length of the fibbonaci sequence to go up to
     * @return the sum of the numbers
     */
    private static Integer fibboSum(int length){
        int total = 0;
        for(int i = length; i>0; i--){
            total += fibboStep(i);
        }
        return total;
    }
}
