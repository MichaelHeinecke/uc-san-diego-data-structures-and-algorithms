import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class PrimitiveCalculatorTest {
    // Constraint: 1 ≤ value ≤ 10^6
    @Test
    void testPrimitiveCalculator_InputMin() {
        assertEquals(Arrays.asList(1), PrimitiveCalculator.determineOptimalSequence(1));
    }

    @Test
    void testPrimitiveCalculator_InputFive() {
        assertEquals(Arrays.asList(1, 3, 4, 5), PrimitiveCalculator.determineOptimalSequence(5));
    }

    @Test
    void testPrimitiveCalculator_InputTen() {
        assertEquals(Arrays.asList(1, 3, 9, 10), PrimitiveCalculator.determineOptimalSequence(10));
    }

    @Test
    void testPrimitiveCalculator_Input_96234() {
        assertEquals(Arrays.asList(1, 3, 9, 10, 11, 33, 99, 297, 891, 2673, 8019, 16038, 16039, 48117, 96234),
                PrimitiveCalculator.determineOptimalSequence(96234));
    }
}
