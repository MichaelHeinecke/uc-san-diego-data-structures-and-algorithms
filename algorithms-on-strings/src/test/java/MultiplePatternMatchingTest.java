import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class MultiplePatternMatchingTest {

    @Test
    void whenPatternMatchesOverlap_ReturnCorrectNumberOfMatches() {
        String text = "AAA";
        String[] patterns = new String[] {"AA"};

        List<Integer> expectedResult = List.of(0, 1);

        assertIterableEquals(expectedResult, MultiplePatternMatching.trieMatch(text, patterns));
    }

    @Test
    void whenNoMatchesAreFound_ReturnEmptyList() {
        String text = "AA";
        String[] patterns = new String[] {"T"};

        List<Integer> expectedResult = List.of();

        assertIterableEquals(expectedResult, MultiplePatternMatching.trieMatch(text, patterns));
    }

    @Test
    void whenMultiplePatternsAreProvided_ReturnCorrectIndexes() {
        String text = "AATCGGGTTCAATCGGGGT";
        String[] patterns = new String[] {"ATCG", "GGGT"};

        List<Integer> expectedResult = List.of(1, 4, 11, 15);

        assertIterableEquals(expectedResult, MultiplePatternMatching.trieMatch(text, patterns));
    }

}
