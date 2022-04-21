import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySumTest {

    @Test
    void sumOfArray() {
        int[][] test1 = {{1,2,3},{1,2,3},{1,2,3}};
        assertEquals(18, ArraySum.sumOfArray(test1));

        int[][] test2 = {{1,2},{1,2,3,4},{1,2,3}};
        assertEquals(19, ArraySum.sumOfArray(test2));

    }
}