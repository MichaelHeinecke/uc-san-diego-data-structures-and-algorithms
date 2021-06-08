import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreatestCommonDivisorTest {

    @Test
    void testGreatestCommonDivisorResult1() {
        assertEquals(1, GreatestCommonDivisor.calculateGreatestCommonDivisor(18, 35));
    }

    @Test
    void testGreatestCommonDivisorEqualInputs() {
        assertEquals(18, GreatestCommonDivisor.calculateGreatestCommonDivisor(18, 18));
    }

    @Test
    void testGreatestCommonDivisorResultHighNumber() {
        assertEquals(17657, GreatestCommonDivisor.calculateGreatestCommonDivisor(28851538, 1183019));
    }
}
