import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExitFromMazeTest {
    @Test
    void testCheckForConnectionBetweenEntryAndExit_HasConnection() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1, 3), List.of(0, 2), List.of(1, 3), List.of(2, 0)
        );
        int mazeEntryVertex = 0;
        int mazeExitVertex = 3;

        assertEquals(1, ExitFromMaze.checkForConnectionBetweenEntryAndExit(adjacencyList, mazeEntryVertex, mazeExitVertex));
    }

    @Test
    void testCheckForConnectionBetweenEntryAndExit_HasNoConnection() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1), List.of(0, 2), List.of(1), List.of()
        );
        int mazeEntryVertex = 0;
        int mazeExitVertex = 3;

        assertEquals(0, ExitFromMaze.checkForConnectionBetweenEntryAndExit(adjacencyList, mazeEntryVertex, mazeExitVertex));
    }
}
