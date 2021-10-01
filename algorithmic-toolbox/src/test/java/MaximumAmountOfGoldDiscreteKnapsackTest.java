import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumAmountOfGoldDiscreteKnapsackTest {
    @Test
    void testMaximumAmountOfGoldDiscreteKnapsackTest() {
        assertEquals(9,
                MaximumAmountOfGoldDiscreteKnapsack.determineMaximumAmountOfGold(10, new int[]{1, 4, 8})
        );
    }
}



