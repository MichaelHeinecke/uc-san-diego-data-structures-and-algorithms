import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructBurrowsWheelerTransformTest {
    private ConstructBurrowsWheelerTransform bwt;

    @BeforeEach
    void setUp() {
        bwt = new ConstructBurrowsWheelerTransform();
    }

    @AfterEach
    void tearDown() {
        bwt = null;
    }

    @ParameterizedTest
    @ArgumentsSource(ConstructBurrowsWheelerTransformTestArgumentsProvider.class)
    void whenStringIsProvided_ReturnBurrowsWheelerTransformOfString(String input, String expectedOutput) {
        assertEquals(expectedOutput, bwt.constructBurrowsWheelerTransform(input));
    }

    static class ConstructBurrowsWheelerTransformTestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("AA$", "AA$"),
                    Arguments.of("ACACACAC$", "CCCC$AAAA"),
                    Arguments.of("AGACATA$", "ATG$CAAA")
            );
        }
    }

}
