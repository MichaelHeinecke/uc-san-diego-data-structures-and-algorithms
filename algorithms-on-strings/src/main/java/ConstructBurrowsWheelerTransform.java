import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConstructBurrowsWheelerTransform {
    public String constructBurrowsWheelerTransform(String string) {
        // The Burrows Wheeler Transform (BWT) is the last column of the BWT matrix
        String[] bwtMatrix = new String[string.length()];

        for (int i = 0; i < string.length(); i++) {
            bwtMatrix[i] = string;
            string = string.substring(string.length() - 1) + string.substring(0, string.length() - 1 );
        }

        Arrays.sort(bwtMatrix);

        StringBuilder bwt = new StringBuilder();
        for (String row : bwtMatrix) {
            bwt.append(row.substring(row.length() - 1));
        }

        return bwt.toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String input = in.readLine();
            System.out.println(new ConstructBurrowsWheelerTransform().constructBurrowsWheelerTransform(input));
        }

    }

}
