import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HeapBuilderTest {
    @Test
    public void testGenerateSwaps_SimpleInput() {
        HeapBuilder heapBuilder = new HeapBuilder(new int[]{5, 4, 3, 2, 1});

        heapBuilder.generateSwaps();

        List<HeapBuilder.Swap> result = heapBuilder.getSwaps();
        List<HeapBuilder.Swap> expectedResult = Arrays.asList(
                new HeapBuilder.Swap(1, 4), new HeapBuilder.Swap(0, 1), new HeapBuilder.Swap(1, 3)
        );

        assertEquals(3, result.size());
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGenerateSwaps_InputIsMinHeap() {
        HeapBuilder heapBuilder = new HeapBuilder(new int[]{1, 2, 3, 4, 5});

        heapBuilder.generateSwaps();

        assertEquals(0, heapBuilder.getSwaps().size());
    }

    @Test
    public void testSwapEquals_SwapsMatch() {
        HeapBuilder.Swap swap1 = new HeapBuilder.Swap(1, 2);
        HeapBuilder.Swap swap2 = new HeapBuilder.Swap(1, 2);

        assertEquals(swap1, swap2);
    }

    @Test
    public void testSwapEquals_SwapsDoNotMatch() {
        HeapBuilder.Swap swap1 = new HeapBuilder.Swap(1, 2);
        HeapBuilder.Swap swap2 = new HeapBuilder.Swap(1, 3);

        assertNotEquals(swap1, swap2);
    }
}
