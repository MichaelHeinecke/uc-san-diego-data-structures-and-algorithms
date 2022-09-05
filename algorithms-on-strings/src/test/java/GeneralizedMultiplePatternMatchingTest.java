import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class GeneralizedMultiplePatternMatchingTest {
    private GeneralizedMultiplePatternMatching trie;

    @BeforeEach
    void setUp() {
        trie = new GeneralizedMultiplePatternMatching();
    }

    @AfterEach
    void tearDown() {
        trie = null;
    }

    @ParameterizedTest
    @ArgumentsSource(GeneralizedMultiplePatternMatchingTestArgumentsProvider.class)
    void whenPatternsAndTextAreProvided_ReturnCorrectStartIndexesOfMatches(String text, String[] patterns, List<Integer> expectedStartIndexes) {
        trie.buildTrie(patterns);
        assertIterableEquals(expectedStartIndexes, trie.findMatches(text));
    }

    static class GeneralizedMultiplePatternMatchingTestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("AAA", new String[]{"AA"}, List.of(0, 1)), // pattern matches overlap
                    Arguments.of("AA", new String[]{"T"}, List.of()), // no matches
                    Arguments.of("AATCGGGTTCAATCGGGGT", new String[]{"ATCG", "GGGT"}, List.of(1, 4, 11, 15)), // multiple patterns
                    Arguments.of("ACATA", new String[]{"AT", "A", "AG"}, List.of(0, 2, 4)) // pattern is prefix of other patterns
            );
        }
    }

}
