import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PartitioningSouvenirsTest {
    @Test
    void testPartitioningSouvenirs_LessThanThreeItems() {
        assertFalse(PartitioningSouvenirs.checkThreeWayPartitioningPossible(new int[]{1, 4, 8}));
    }

    @Test
    void testPartitioningSouvenirs_TotalSumNotDivisibleByThree() {
        assertFalse(PartitioningSouvenirs.checkThreeWayPartitioningPossible(new int[]{4, 4, 3}));
    }

    @Test
    void testPartitioningSouvenirs_TotalSumDivisibleByThree_PossibleToPartition() {
        assertTrue(PartitioningSouvenirs.checkThreeWayPartitioningPossible(new int[]{4, 4, 4}));
    }

    @Test
    void testPartitioningSouvenirs_TotalSumDivisibleByThree_NotPossibleToPartition() {
        assertFalse(PartitioningSouvenirs.checkThreeWayPartitioningPossible(new int[]{3, 3, 3, 3}));
    }

    @Test
    void testPartitioningSouvenirs_TotalSumDivisibleByThree_PossibleToPartition_LongInput() {
        assertTrue(PartitioningSouvenirs.checkThreeWayPartitioningPossible(new int[]{1, 2, 3, 4, 5, 5, 7, 7, 8, 10, 12,
                19, 25}));
    }
}