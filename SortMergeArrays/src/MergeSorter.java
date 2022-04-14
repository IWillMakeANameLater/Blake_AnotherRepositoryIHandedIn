import java.util.Arrays;

public class MergeSorter {

    public MergeSorter(){

    }

    public int[] mergeSort(int[] inputArray) {
        if(inputArray.length == 1){
            return inputArray;
        }
        int[] leftHalf = mergeSort(Arrays.copyOfRange(inputArray, 0, (int) Math.ceil(inputArray.length/2)));
        int[] rightHalf = mergeSort(Arrays.copyOfRange(inputArray, (int) Math.ceil(inputArray.length/2), inputArray.length));
        return merge(leftHalf, rightHalf);
    }


    public int[] merge(int[] array1, int[] array2){
        int arr1Current = 0;
        int arr2Current = 0;

        int[] fusedArray = new int[array1.length + array2.length];
        for(int i = 0; i < fusedArray.length; i++) {
            int arr1Val = array1[arr1Current];
            int arr2Val = array2[arr2Current];
            if (arr1Val >= arr2Val) {
                fusedArray[i] = arr1Val;
                if (arr1Current < array1.length - 1) {
                    arr1Current++;
                } else {
                    array1[arr1Current] = array2[array2.length - 1] - 1;
                }
            } else {
                fusedArray[i] = arr2Val;
                if (arr2Current < array2.length - 1) {
                    arr2Current++;
                } else {
                    array2[arr2Current] = array1[array1.length - 1] - 1;
                }
            }
        }
        return fusedArray;
    }
}
