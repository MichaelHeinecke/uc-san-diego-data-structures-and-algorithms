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
        assertEquals(151, FibonacciPisanoPeriod.calculateFibonacciModulo(2816213588L, 239));
    }
}
