import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaximumPairwiseProductTest {
    @Test
    void testMaximumPairwiseProduct() {
        assertEquals(6, MaximumPairwiseProduct.maximumPairwiseProduct(new int[]{1, 2, 3}));
    }
}
