import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarFuelingTest {
    @Test
    void testCalculateMinimumNumberOfFuelingStops_Possible() {
        assertEquals(2, CarFueling.calculateMinimumNumberOfFuelingStops(950, 400, new int[]{200, 375, 550, 750}));
    }

    @Test
    void testCalculateMinimumNumberOfFuelingStops_NotPossible() {
        assertEquals(-1, CarFueling.calculateMinimumNumberOfFuelingStops(10, 3, new int[]{1, 2, 5, 9}));
    }
}
