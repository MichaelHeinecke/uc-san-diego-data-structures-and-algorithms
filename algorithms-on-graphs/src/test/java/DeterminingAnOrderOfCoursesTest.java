import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeterminingAnOrderOfCoursesTest {
    @Test
    void testTopologicalSort1() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1), List.of(), List.of(0), List.of(0)
        );

        List<Integer> expectedOrder = List.of(3, 2, 0, 1);

        assertEquals(expectedOrder, DeterminingAnOrderOfCourses.topologicalSort(adjacencyList));
    }

    @Test
    void testTopologicalSort2() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(), List.of(), List.of(0), List.of()
        );

        List<Integer> expectedOrder = List.of(3, 2, 1, 0);

        assertEquals(expectedOrder, DeterminingAnOrderOfCourses.topologicalSort(adjacencyList));
    }
}
