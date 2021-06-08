import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciTest {
    @Test
    void testFibonacciInputZero() {
        assertEquals(0, Fibonacci.calculateFibonacci(0));
    }

    @Test
    void testFibonacciInputOne() {
        assertEquals(1, Fibonacci.calculateFibonacci(1));
    }

    @Test
    void testFibonacciInputTwo() {
        assertEquals(1, Fibonacci.calculateFibonacci(2));
    }

    @Test
    void testFibonacciInputTen() {
        assertEquals(55, Fibonacci.calculateFibonacci(10));
    }
}
