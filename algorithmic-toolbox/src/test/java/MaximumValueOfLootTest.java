import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class MaximumValueOfLootTest {
    @Test
    void testCalculateMaximumValueOfLoot1() {
        Map<Double, Integer> worthAmount = new TreeMap<>(Comparator.reverseOrder());
        worthAmount.put(60/20d, 20);
        worthAmount.put(100/50d, 50);
        worthAmount.put(120/30d, 30);
        assertEquals(180.0000d, MaximumValueOfLoot.calculateMaximumValueOfLoot(50, worthAmount), Math.pow(10, -3));
    }

    @Test
    void testCalculateMaximumValueOfLoot2() {
        Map<Double, Integer> worthAmount = new TreeMap<>(Comparator.reverseOrder());
        worthAmount.put(500/30d, 30);
        assertEquals(166.6667, MaximumValueOfLoot.calculateMaximumValueOfLoot(10, worthAmount), Math.pow(10, -3));
    }
}
