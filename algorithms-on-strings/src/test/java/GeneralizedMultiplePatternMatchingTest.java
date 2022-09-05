import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class GeneralizedMultiplePatternMatchingTest {

    @Test
    void whenPatternMatchesOverlap_ReturnCorrectNumberOfMatches() {
        String text = "AAA";
        String[] patterns = new String[] {"AA"};
        GeneralizedMultiplePatternMatching.Trie trie = new GeneralizedMultiplePatternMatching.Trie(patterns);

        List<Integer> expectedResult = List.of(0, 1);

        assertIterableEquals(expectedResult, trie.findMatches(text));
    }

    @Test
    void whenNoMatchesAreFound_ReturnEmptyList() {
        String text = "AA";
        String[] patterns = new String[] {"T"};
        GeneralizedMultiplePatternMatching.Trie trie = new GeneralizedMultiplePatternMatching.Trie(patterns);

        List<Integer> expectedResult = List.of();

        assertIterableEquals(expectedResult, trie.findMatches(text));
    }

    @Test
    void whenMultiplePatternsAreProvided_ReturnCorrectIndexes() {
        String text = "AATCGGGTTCAATCGGGGT";
        String[] patterns = new String[] {"ATCG", "GGGT"};
        GeneralizedMultiplePatternMatching.Trie trie = new GeneralizedMultiplePatternMatching.Trie(patterns);

        List<Integer> expectedResult = List.of(1, 4, 11, 15);

        assertIterableEquals(expectedResult, trie.findMatches(text));
    }

    @Test
    void whenPatternIsPrefixOfAnotherPattern_ReturnCorrectIndexes() {
        String text = "ACATA";
        String[] patterns = new String[] {"AT", "A", "AG"};
        GeneralizedMultiplePatternMatching.Trie trie = new GeneralizedMultiplePatternMatching.Trie(patterns);

        List<Integer> expectedResult = List.of(0, 2, 4);

        assertIterableEquals(expectedResult, trie.findMatches(text));
    }

}
