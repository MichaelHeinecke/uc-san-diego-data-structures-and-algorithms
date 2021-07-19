import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MoneyChangeTest {
    @Test
    void testFibonacciInputMin() {
        assertEquals(1, MoneyChange.calculateNumberOfCoins(1));
    }

    @Test
    void testFibonacciInputTwo() {
        assertEquals(2, MoneyChange.calculateNumberOfCoins(2));
    }

    @Test
    void testFibonacciInput28() {
        assertEquals(6, MoneyChange.calculateNumberOfCoins(28));
    }

    @Test
    void testFibonacciInputMax() {
        assertEquals(100, MoneyChange.calculateNumberOfCoins(10 * 10 * 10));
    }
}
