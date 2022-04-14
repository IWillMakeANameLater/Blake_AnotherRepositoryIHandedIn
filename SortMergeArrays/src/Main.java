public class Main {
    public static void main(String[] args) {
        MergeSorter test = new MergeSorter();
        int[] baseArray = test.mergeSort(new int[]{1,0,1});
        for(int i = 0; i < baseArray.length; i++){
            System.out.println(baseArray[i]);
        }
    }
}
