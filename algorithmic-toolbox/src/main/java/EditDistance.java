import java.util.Arrays;
import java.util.Scanner;

class EditDistance {
    final static Scanner scanner = new Scanner(System.in);

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int calculateEditDistance(String string1, String string2) {
        // Constraint: two lower-case letter strings between 1 and 100 characters
        // Return if strings match
        if (string1.equals(string2)) return 0;

        char[] charsString1 = string1.toCharArray();
        char[] charsString2 = string2.toCharArray();

        // Construct edit distance matrix
        int[][] editDistanceMatrix = new int[string1.length() + 1][string2.length() + 1];

        for (int idx = 0; idx < editDistanceMatrix.length; idx++) {
            editDistanceMatrix[idx][0] = idx;
        }

        for (int idx = 0; idx < editDistanceMatrix[0].length; idx++) {
            editDistanceMatrix[0][idx] = idx;
        }

        for (int j = 1; j < editDistanceMatrix[0].length; j++) {
            for (int i = 1; i < editDistanceMatrix.length; i++) {
                int insertion = editDistanceMatrix[i][j - 1] + 1;
                int deletion = editDistanceMatrix[i - 1][j] + 1;
                int match = editDistanceMatrix[i - 1][j - 1];
                int mismatch = editDistanceMatrix[i - 1][j - 1] + 1;

                if (charsString1[i - 1] == charsString2[j - 1]) {
                    editDistanceMatrix[i][j] = min(insertion, deletion, match);
                } else {
                    editDistanceMatrix[i][j] = min(insertion, deletion, mismatch);
                }
            }
        }

        return editDistanceMatrix[string1.length()][string2.length()];
    }

    public static void main(String[] args) {
        String s = scanner.next();
        String t = scanner.next();

        System.out.println(calculateEditDistance(s, t));

        scanner.close();
    }

}
