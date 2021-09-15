import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EditDistanceTest {
    @Test
    void testCalculateEditDistance_InputEqualStrings() {
        assertEquals(0, EditDistance.calculateEditDistance("ab", "ab"));
    }

    @Test
    void testCalculateEditDistance_InputNonEqualStrings_1() {
        assertEquals(3, EditDistance.calculateEditDistance("short", "ports"));
    }

    @Test
    void testCalculateEditDistance_InputNonEqualStrings_2() {
        assertEquals(5, EditDistance.calculateEditDistance("editing", "distance"));
    }
}
