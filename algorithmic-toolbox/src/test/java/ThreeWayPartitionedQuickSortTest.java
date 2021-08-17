import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeWayPartitionedQuickSortTest {
    @Test
    void testThreeWayPartitionedQuickSort() {
        int[] inputArray = new int[]{2, 3, 9, 2, 2};
        int[] sortedArray = new int[]{2, 2, 2, 3, 9};
        ThreeWayPartitionedQuickSort.randomizedQuickSort(inputArray, 0, inputArray.length - 1);
        assertEquals(sortedArray.length, inputArray.length);
        for (int i = 0; i < inputArray.length; i++) {
            assertEquals(sortedArray[i], inputArray[i]);
        }
    }
}
