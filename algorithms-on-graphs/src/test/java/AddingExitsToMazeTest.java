import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddingExitsToMazeTest {
    @Test
    void testCheckForConnectionBetweenEntryAndExit_HasConnection() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1), List.of(0, 2), List.of(1), List.of()
        );
        int mazeEntryVertex = 0;
        int mazeExitVertex = 3;

        assertEquals(2, AddingExitsToMaze.findNumberOfConnectedComponents(adjacencyList));
    }
}
