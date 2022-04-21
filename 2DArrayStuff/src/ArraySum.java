public class ArraySum {
    public static int sumOfArray(int[][] inputArray){
        int totalValue = 0;
        for(int[] col : inputArray){
            for(int num : col){
                totalValue += num;
            }
        }
        return totalValue;
    }
}
