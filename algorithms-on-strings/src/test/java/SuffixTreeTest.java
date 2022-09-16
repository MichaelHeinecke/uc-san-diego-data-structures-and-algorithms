import org.hamcrest.Matcher;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class SuffixTreeTest {

    @ParameterizedTest
    @ArgumentsSource(SuffixTreeTestArgumentsProvider.class)
    void whenTextIsProvided_CalculateSuffixTreeEdges(SuffixTree suffixTree, List<Matcher<String>> expectedSuffixTreeEdgeLabels) {
        List<String> suffixTreeEdgeLabels = suffixTree.computeSuffixTreeEdges();
        assertThat(suffixTreeEdgeLabels, containsInAnyOrder(expectedSuffixTreeEdgeLabels.toArray()));
    }

    static class SuffixTreeTestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(new SuffixTree("A$"), List.of("A$", "$")),
                    Arguments.of(new SuffixTree("ACA$"), List.of("$", "A", "$", "CA$", "CA$")),
                    Arguments.of(new SuffixTree("ATAAATG$"),
                            List.of("AAATG$", "G$", "T", "ATG$", "TG$", "A", "A", "AAATG$", "G$", "T", "G$", "$")
                    )
            );
        }
    }

}
