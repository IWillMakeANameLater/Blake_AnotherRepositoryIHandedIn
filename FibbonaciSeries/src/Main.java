import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(fibboStep(10, 1, 0));
    }

    private static int fibboStep(int steps, ArrayList<Integer> sequence){
        if (steps == 1){
            return previousStep;
        } else {
            return previousStep + fibboStep(steps-1, previousStep + previousStep2, previousStep);
        }
    }
}
