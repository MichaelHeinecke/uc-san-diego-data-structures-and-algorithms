import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ReconstructStringFromBurrowsWheelerTransform {

    public String reconstructStringFromBurrowsWheelerTransform(String bwt) {
        // The Burrows Wheeler Transform (BWT) is the last column of the BWT matrix
        Map<Character, Integer> charCounts = new HashMap<>();
        List<Integer> charRanks = new ArrayList<>();

        for (char c : bwt.toCharArray()) {
            int count = charCounts.getOrDefault(c, 0);
            charRanks.add(count);
            charCounts.put(c, ++count);
        }

        Map<Character, Integer> firstColumn = new HashMap<>();
        int charRange = 0;

        List<Map.Entry<Character, Integer>> sortedCharCounts = charCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

        for (Map.Entry<Character, Integer> e : sortedCharCounts) {
            firstColumn.put(e.getKey(), charRange);
            charRange = charRange + e.getValue();
        }

        StringBuilder reconstructed = new StringBuilder("$");
        int rowIndex = 0;
        while (bwt.charAt(rowIndex) != '$') {
            char c = bwt.charAt(rowIndex);
            reconstructed.insert(0, c);
            // jump to row that starts with character of same rank
            rowIndex = firstColumn.get(c) + charRanks.get(rowIndex);
        }

        return reconstructed.toString();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String input = in.readLine();
            System.out.println(new ReconstructStringFromBurrowsWheelerTransform().reconstructStringFromBurrowsWheelerTransform(input));
        }
    }

}
