import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciPisanoPeriodTest {
    @Test
    void testCalculateLengthOfPisanoPeriod() {
        assertEquals(8, FibonacciPisanoPeriod.calculateLengthOfPisanoPeriod(3));
    }

    @Test
    void testFibonacciModuloSmallInput() {
        assertEquals(161, FibonacciPisanoPeriod.calculateFibonacciModulo(239, 1000));
    }

    @Test
    void testFibonacciModuloLargeInput() {
        assertEquals(151, FibonacciPisanoPeriod.calculateFibonacciModulo(2_816_213_588L, 239));
    }

    @Test
    void testFibonacciModuloVeryLargeInput() {
        assertEquals(0, FibonacciPisanoPeriod.calculateFibonacciModulo(9_999_999_999_999L, 17));
    }
}
