import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReconstructStringFromBurrowsWheelerTransformTest {
    private ReconstructStringFromBurrowsWheelerTransform bwt;

    @BeforeEach
    void setUp() {
        bwt = new ReconstructStringFromBurrowsWheelerTransform();
    }

    @AfterEach
    void tearDown() {
        bwt = null;
    }

    @ParameterizedTest
    @ArgumentsSource(ReconstructStringFromBurrowsWheelerTransformTestArgumentsProvider.class)
    void whenBurrowsWheelerTransformIsProvided_ReturnReconstructedString(String input, String expectedOutput) {
        assertEquals(expectedOutput, bwt.reconstructStringFromBurrowsWheelerTransform(input));
    }

    static class ReconstructStringFromBurrowsWheelerTransformTestArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("AC$A", "ACA$"),
                    Arguments.of("AGGGAA$", "GAGAGA$"),
                    Arguments.of("do$oodwg", "dogwood$"),
                    Arguments.of("e$elplepa", "appellee$"),
                    Arguments.of("torg$_hntriatnet_wo_sb", "another_string_to_bwt$"),
                    Arguments.of("G$AAACAAAAAACCACCCAAAGCGACCACACCCTGGGTTTTTTCTTGGGGTTGTC", "AAAAAAAACCCCCTTTTGTGTGTGTGTTTGGGGCCCAAAACACACACCTGCACG$"),
                    Arguments.of("T$AAGGGTAGTCCCCCCCGAAAAAGCGGGGGGGAGGGTTTTTTTTTTTTGTG", "AAAAGGGGGGGTTTTTTTTCCCCCCCCGGGGGTTTTTTTAGGAGAGAGAGT$")
            );
        }
    }

}
