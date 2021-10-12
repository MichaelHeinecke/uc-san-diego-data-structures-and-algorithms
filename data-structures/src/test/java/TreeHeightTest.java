import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeHeightTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    private void readFromFileInputStream(String pathToFile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(pathToFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setIn(fileInputStream);
    }

    @Test
    public void testCase1() {
        final String testFile = "src/test/resources/tree-height-test-resources/01";
        readFromFileInputStream(testFile);

        TreeHeight.main(new String[0]);

        assertEquals("3", outContent.toString().trim());
    }

    @Test
    public void testCase2() {
        final String testFile = "src/test/resources/tree-height-test-resources/02";
        readFromFileInputStream(testFile);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TreeHeight.main(new String[0]);

        assertEquals("4", outContent.toString().trim());
    }

    @Test
    public void testCase23() {
        final String testFile = "src/test/resources/tree-height-test-resources/23";
        readFromFileInputStream(testFile);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TreeHeight.main(new String[0]);

        assertEquals("33334", outContent.toString().trim());
    }

    @Test
    public void testCase24() {
        final String testFile = "src/test/resources/tree-height-test-resources/24";
        readFromFileInputStream(testFile);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TreeHeight.main(new String[0]);

        assertEquals("50001", outContent.toString().trim());
    }
}
