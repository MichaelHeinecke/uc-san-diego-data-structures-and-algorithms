import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    @Test
    void testBinarySearchIndexOfKey_NotInSequence() {
        assertEquals(-1, BinarySearch.binarySearchIndexOfKey(23, new int[]{1, 5, 8, 12, 13}));
    }

    @Test
    void testBinarySearchIndexOfKey_InSequence() {
        assertEquals(2, BinarySearch.binarySearchIndexOfKey(8, new int[]{1, 5, 8, 12, 13}));
    }

    @Test
    void testBinarySearchIndexOfKey_LastInSequence() {
        assertEquals(4, BinarySearch.binarySearchIndexOfKey(13, new int[]{1, 5, 8, 12, 13}));
    }

    @Test
    void testBinarySearchIndexOfKey_FailingGraderTest() {
        assertEquals(1, BinarySearch.binarySearchIndexOfKey(2, new int[]{1, 2, 3, 4, 5}));
    }
}
