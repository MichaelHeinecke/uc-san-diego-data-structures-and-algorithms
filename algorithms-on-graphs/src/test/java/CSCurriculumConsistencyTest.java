import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSCurriculumConsistencyTest {
    @Test
    void testIsCurriculumAcyclic_IsAcyclic() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1), List.of(2), List.of(0), List.of(0)
        );

        assertEquals(1, CSCurriculumConsistency.isAcyclic(adjacencyList));
    }

    @Test
    void testIsCurriculumAcyclic_IsNotAcyclic() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(1, 2, 3), List.of(2, 4), List.of(3, 4), List.of(), List.of()
        );

        assertEquals(0, CSCurriculumConsistency.isAcyclic(adjacencyList));
    }
}
