import java.util.Scanner;

public class LeastCommonMultiple {
    final static Scanner sc = new Scanner(System.in);

    public static long calculateLeastCommonMultiple(int a, int b) {
        // constraint: 1 <= a, b <= 10^7
        return ((long) a * b) / GreatestCommonDivisor.calculateGreatestCommonDivisor(a, b);
    }

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(calculateLeastCommonMultiple(a, b));
    }
}
