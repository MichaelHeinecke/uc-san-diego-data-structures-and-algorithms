import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BipartiteGraphTest {

    @Test
    void whenGraphIsNotBipartite_ReturnThatGraphIsNotBipartite() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1, 2, 3), List.of(0, 2), List.of(0, 1), List.of(0)
        );

        assertEquals(0, BipartiteGraph.isBipartite(adjacencyList));
    }

    @Test
    void whenGraphIsBipartite_ReturnThatGraphIsBipartite() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(3), List.of(3, 4), List.of(3), List.of(0, 1, 2), List.of(1)
        );

        assertEquals(1, BipartiteGraph.isBipartite(adjacencyList));
    }

}
