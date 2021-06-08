import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargeFibonacciLastDigitTest {
    @Test
    void testFibonacciInputZero() {
        assertEquals(0, LargeFibonacciLastDigit.calculateFibonacciLastDigit(0));
    }

    @Test
    void testFibonacciInputOne() {
        assertEquals(1, LargeFibonacciLastDigit.calculateFibonacciLastDigit(1));
    }

    @Test
    void testFibonacciInputTwo() {
        assertEquals(1, LargeFibonacciLastDigit.calculateFibonacciLastDigit(2));
    }

    @Test
    void testFibonacciInputTen() {
        assertEquals(5, LargeFibonacciLastDigit.calculateFibonacciLastDigit(10));
    }

    @Test
    void testFibonacciInput200() {
        assertEquals(5, LargeFibonacciLastDigit.calculateFibonacciLastDigit(200));
    }

    @Test
    void testFibonacciInput331() {
        assertEquals(9, LargeFibonacciLastDigit.calculateFibonacciLastDigit(331));
    }

    @Test
    void testFibonacciInput327305() {
        assertEquals(5, LargeFibonacciLastDigit.calculateFibonacciLastDigit(327305));
    }
}
