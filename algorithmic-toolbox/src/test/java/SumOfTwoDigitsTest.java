import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SumOfTwoDigitsTest {
    @Test
    void additionTest() {
        assertEquals(2, SumOfTwoDigits.add(1, 1));
    }
}
