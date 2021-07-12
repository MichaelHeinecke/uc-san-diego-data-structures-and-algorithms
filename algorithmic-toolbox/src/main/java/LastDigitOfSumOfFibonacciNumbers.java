import java.util.Scanner;

public class LastDigitOfSumOfFibonacciNumbers {
    static final Scanner sc = new Scanner(System.in);

    public static long calculateLastDigitOfSumOfFibonacciNumbers(long n) {
        // constraint: 0 ≤ 𝑛 ≤ 10^14
        long previous = 0;
        long current = 1;

        if (n == 0) {
            return 0;
        }

        for (int i = 0; i <= n; i++) {
            long temp;
            temp = current;
            current = (previous + current) % 10;
            previous = temp;
        }
        return current - 1;
    }

    public static void main(String[] args) {
        System.out.println(calculateLastDigitOfSumOfFibonacciNumbers(sc.nextLong()));
        sc.close();
    }
}
