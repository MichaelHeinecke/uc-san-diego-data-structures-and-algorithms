import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeastCommonMultipleTest {
    @Test
    void testLeastCommonMultipleSmallInput() {
        assertEquals(24, LeastCommonMultiple.calculateLeastCommonMultiple(6, 8));
    }

    @Test
    void testLeastCommonMultipleLargeInput() {
        assertEquals(467970912861L, LeastCommonMultiple.calculateLeastCommonMultiple(761457, 614573));
    }
}
