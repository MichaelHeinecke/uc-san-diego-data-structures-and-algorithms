import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MajorityElementTest {
    @Test
    void testMajorityElement_HasMajorityElement() {
        assertEquals(1, MajorityElement.findMajorityElement(new int[] {2, 3, 9, 2, 2}));
    }

    @Test
    void testMajorityElement_HasNoMajorityElement() {
        assertEquals(0, MajorityElement.findMajorityElement(new int[] {1, 2, 3, 4}));
    }
}
