import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyChangeDynamicProgrammingTest {
    // Constraint: 1 ≤ moneyValue ≤ 10^3
    @Test
    void testFibonacci_InputMin() {
        assertEquals(1, MoneyChangeDynamicProgramming.calculateMinimumNumberOfCoins(1));
    }

    @Test
    void testFibonacci_InputTwo() {
        assertEquals(2, MoneyChangeDynamicProgramming.calculateMinimumNumberOfCoins(2));
    }

    @Test
    void testFibonacci_InputThirtyFour() {
        assertEquals(9, MoneyChangeDynamicProgramming.calculateMinimumNumberOfCoins(34));
    }

    @Test
    void testFibonacci_InputMax() {
        assertEquals(250, MoneyChangeDynamicProgramming.calculateMinimumNumberOfCoins(1000));
    }
}
