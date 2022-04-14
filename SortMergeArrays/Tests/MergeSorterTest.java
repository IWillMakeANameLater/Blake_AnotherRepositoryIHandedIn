import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSorterTest {

    /*
        Tests if the merge method is functioning properly.
        This is important as the algorithm relies heavily on it.

        Checklist:
        Equal lengths, different lengths - should merge them the same
        Values - bigger/smaller, what about equal values?
     */
    @Test
    void merge() {
        MergeSorter test = new MergeSorter();

        int[] arr1 = {7,6,5,4,3};
        int[] arr2 = {5,4,3,2,1};

        int[] arr12merge = test.merge(arr1, arr2);
        assertTrue(Arrays.equals(new int[]{7,6,5,5,4,4,3,3,2,1}, arr12merge));

        int[] arr3 = {3,2,1};
        int[] arr4 = {9,8,7,6,5,4};

        int[] arr34merge = test.merge(arr3, arr4);
        assertTrue(Arrays.equals(new int[]{9,8,7,6,5,4,3,2,1}, arr34merge));

        int[] arr5 = {1};
        int[] arr6 = {1};

        int[] arr56merge = {1,1};
        assertTrue(Arrays.equals(new int[]{1,1}, arr56merge));
    }
}