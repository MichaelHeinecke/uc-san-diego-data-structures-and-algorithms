import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumCostOfFlightTest {

    @Test
    void whenVerticesAreNotConnected_ReturnMinusOne() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1, 2), List.of(2), List.of()
        );
        List<List<Integer>> cost = List.of(
                List.of(7, 5), List.of(2), List.of()
        );
        int startVertex = 2;
        int destinationVertex = 1;

        assertEquals(-1, MinimumCostOfFlight.determineMinimumCostBetweenVertices(adjacencyList, cost,
                startVertex, destinationVertex));
    }

    @Test
    void whenUniqueShortestPathExists_ReturnMinimumCost() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1, 2), List.of(2), List.of(), List.of(0)
        );
        List<List<Integer>> costs = List.of(
                List.of(1, 5), List.of(2), List.of(), List.of(2)
        );
        int startVertex = 0;
        int destinationVertex = 2;

        assertEquals(3, MinimumCostOfFlight.determineMinimumCostBetweenVertices(adjacencyList, costs,
                startVertex, destinationVertex));
    }

    @Test
    void whenMultipleShortestPathExists_ReturnMinimumCost() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1, 2), List.of(2, 3, 4), List.of(1, 4, 3), List.of(), List.of(3)
        );
        List<List<Integer>> costs = List.of(
                List.of(4, 2), List.of(2, 2, 3), List.of(1, 4, 4), List.of(), List.of(1)
        );
        int startVertex = 0;
        int destinationVertex = 4;

        assertEquals(6, MinimumCostOfFlight.determineMinimumCostBetweenVertices(adjacencyList, costs,
                startVertex, destinationVertex));
    }

}
