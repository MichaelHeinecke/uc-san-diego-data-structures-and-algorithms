import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumNumberOfFlightSegmentsTest {

    @Test
    void whenNodesAreNotConnected_ReturnMinusOne() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(2, 3), List.of(5), List.of(0, 3), List.of(2, 0), List.of(1)
        );
        int startNode = 2;
        int destinationNode = 4;

        assertEquals(-1, MinimumNumberOfFlightSegments.determineDistanceBetweenNodes(adjacencyList, startNode, destinationNode));
    }

    @Test
    void whenNodesAreConnected_ReturnDistance() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1, 2, 3), List.of(0, 2), List.of(0, 1), List.of(0)
        );
        int startNode = 1;
        int destinationNode = 3;

        assertEquals(2, MinimumNumberOfFlightSegments.determineDistanceBetweenNodes(adjacencyList, startNode, destinationNode));

    }

}
