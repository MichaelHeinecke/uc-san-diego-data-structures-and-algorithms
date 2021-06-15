import java.util.Scanner;

public class LeastCommonMultiple {
    final static Scanner sc = new Scanner(System.in);

    private static int applyEuclideanAlgorithm(int a, int b) {
        return b == 0 ? a : applyEuclideanAlgorithm(b, a % b);
    }

    public static int calculateGreatestCommonDivisor(int a, int b) {
        // constraint: 1 <= a, b <= 2 * 10^9
        if (a == b) {
            return a;
        } else {
            return a > b ? applyEuclideanAlgorithm(a, b) : applyEuclideanAlgorithm(b, a);
        }
    }

    public static long calculateLeastCommonMultiple(int a, int b) {
        // constraint: 1 <= a, b <= 10^7
        return ((long) a * b) / calculateGreatestCommonDivisor(a, b);
    }

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(calculateLeastCommonMultiple(a, b));
    }
}
