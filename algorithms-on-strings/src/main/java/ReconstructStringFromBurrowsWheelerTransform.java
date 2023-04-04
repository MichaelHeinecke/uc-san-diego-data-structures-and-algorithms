import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReconstructStringFromBurrowsWheelerTransform {

    public String reconstructStringFromBurrowsWheelerTransform(String bwt) {
        CharCount[] charCounts = new CharCount[bwt.length()];
        for (int i = 0; i < bwt.length(); i++) {
            charCounts[i] = new CharCount(bwt.charAt(i), i);
        }
        Arrays.sort(charCounts);

        StringBuilder invertedBwt = new StringBuilder();
        CharCount charCount = charCounts[0];
        for (int i = 0; i < bwt.length(); i++) {
            charCount = charCounts[charCount.count];
            invertedBwt.append(charCount.character);
        }

        return invertedBwt.toString();
    }

    static class CharCount implements Comparable<CharCount> {
        char character;
        int count;

        public CharCount(char character, int count) {
            this.character = character;
            this.count = count;
        }

        @Override
        public int compareTo(CharCount charCount) {
            return Integer.compare(character, charCount.character);
        }

        @Override
        public boolean equals(Object other) {
            if(this == other) return true;

            if(other == null || (this.getClass() != other.getClass())){
                return false;
            }

            CharCount charCount = (CharCount) other;
            return (this.character == charCount.character) && (this.count == charCount.count);
        }

        @Override
        public final int hashCode() {
            int result = 17;
            result = 31 * result + character;
            result = 31 * result + count;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String input = in.readLine();
            System.out.println(new ReconstructStringFromBurrowsWheelerTransform().reconstructStringFromBurrowsWheelerTransform(input));
        }
    }

}
