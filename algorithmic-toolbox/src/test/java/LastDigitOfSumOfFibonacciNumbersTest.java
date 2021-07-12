import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LastDigitOfSumOfFibonacciNumbersTest {
    @Test
    void testCalculateLastDigitOfSumOfFibonacciNumbersSmallInput() {
        assertEquals(4, LastDigitOfSumOfFibonacciNumbers.calculateLastDigitOfSumOfFibonacciNumbers(3));
    }

    @Test
    void testCalculateLastDigitOfSumOfFibonacciNumbersLargeInput() {
        assertEquals(5, LastDigitOfSumOfFibonacciNumbers.calculateLastDigitOfSumOfFibonacciNumbers(100));
    }

    @Test
    void testCalculateLastDigitOfSumOfFibonacciNumbersVeryLargeInput() {
        assertEquals(3, LastDigitOfSumOfFibonacciNumbers.calculateLastDigitOfSumOfFibonacciNumbers(832_564_823_476L));
    }
}
