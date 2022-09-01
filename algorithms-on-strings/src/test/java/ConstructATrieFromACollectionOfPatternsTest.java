import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ConstructATrieFromACollectionOfPatternsTest {

    @Test
    void whenInputIsSinglePattern_ReturnCorrectTrie() {
        String[] patterns = new String[] {"ATA"};
        List<Map<Character, Integer>> trie = new ConstructATrieFromACollectionOfPatterns().buildTrie(patterns);

        List<Map<Character, Integer>> expectedTrie = List.of(
                Map.of('A', 1), Map.of('T', 2), Map.of('A', 3), Map.of()
        );

        assertIterableEquals(expectedTrie, trie);
    }

    @Test
    void whenInputIsMultiplePatternsOfSameLength_ReturnCorrectTrie() {
        String[] patterns = new String[] {"AT", "AG", "AC"};
        List<Map<Character, Integer>> trie = new ConstructATrieFromACollectionOfPatterns().buildTrie(patterns);

        List<Map<Character, Integer>> expectedTrie = List.of(
                Map.of('A', 1), Map.of('T', 2, 'G', 3, 'C', 4), Map.of(), Map.of(),
                Map.of()
        );

        assertIterableEquals(expectedTrie, trie);
    }

    @Test
    void whenInputIsMultiplePatternsOfDifferentLength_ReturnCorrectTrie() {
        String[] patterns = new String[] {"ATAGA", "ATC", "GAT"};
        List<Map<Character, Integer>> trie = new ConstructATrieFromACollectionOfPatterns().buildTrie(patterns);

        List<Map<Character, Integer>> expectedTrie = List.of(
                Map.of('A', 1, 'G', 7), Map.of('T', 2), Map.of('A', 3, 'C', 6),
                Map.of('G', 4), Map.of('A', 5), Map.of(), Map.of(), Map.of('A', 8), Map.of('T', 9),
                Map.of()
        );

        assertIterableEquals(expectedTrie, trie);
    }

}
