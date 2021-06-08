import java.util.Scanner;

public class GreatestCommonDivisor {
    final static Scanner sc = new Scanner(System.in);

    private static int applyEuclideanAlgorithm(int a, int b){
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

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(calculateGreatestCommonDivisor(a, b));
    }
}
