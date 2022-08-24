import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectingAnomaliesInCurrencyExchangeRatesTest {

    @Test
    void whenGraphContainsNoNegativeCycle_ReturnZero() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1, 2), List.of(2), List.of(), List.of(0)
        );
        List<List<Integer>> costs = List.of(
                List.of(1, 5), List.of(2), List.of(), List.of(2)
        );

        assertEquals(0, DetectingAnomaliesInCurrencyExchangeRates.hasNegativeWeightCycle(adjacencyList, costs));
    }

    @Test
    void whenGraphContainsNegativeCycle_ReturnOne() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1), List.of(2), List.of(0), List.of(0)
        );
        List<List<Integer>> costs = List.of(
                List.of(-5), List.of(2), List.of(1), List.of(2)
        );

        assertEquals(1, DetectingAnomaliesInCurrencyExchangeRates.hasNegativeWeightCycle(adjacencyList, costs));
    }

}
