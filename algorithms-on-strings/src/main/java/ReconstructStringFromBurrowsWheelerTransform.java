import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ReconstructStringFromBurrowsWheelerTransform {
    public String reconstructStringFromBurrowsWheelerTransform(String bwt) {
        // The Burrows Wheeler Transform (BWT) is the last column of the BWT matrix
        // The original string can be reconstructed iteratively by adding the BWT to the matrix
        // and sorting the rows length(bwt) times
        String[] bwtMatrix = new String[bwt.length()];
        Arrays.fill(bwtMatrix, "");

        for (int i = 0; i < bwt.length(); i++) {
            for (int j = 0; j < bwt.length(); j++) {
                bwtMatrix[j] = bwt.charAt(j) + bwtMatrix[j];
            }
            Arrays.sort(bwtMatrix);
        }

        // There will be exactly one element in the array ending with "$"
        return Arrays.stream(bwtMatrix)
                .filter(e -> e.endsWith("$"))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String input = in.readLine();
            System.out.println(new ReconstructStringFromBurrowsWheelerTransform().reconstructStringFromBurrowsWheelerTransform(input));
        }
    }

}
