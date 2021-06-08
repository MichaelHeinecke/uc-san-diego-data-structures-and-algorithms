import java.util.Scanner;

public class LargeFibonacciLastDigit {
    static final Scanner sc = new Scanner(System.in);

    public static int calculateFibonacciLastDigit(int n) {
        // constraint: 0 <= n <= 10^7

        if (n <= 1) {
            return n;
        }

        int[] fibonacciNumbers = new int[n + 1];
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;

        for (int idx = 2; idx <= n; idx++) {
            fibonacciNumbers[idx] = (fibonacciNumbers[idx - 1] + fibonacciNumbers[idx - 2]) % 10;
        }

        return fibonacciNumbers[n];
    }

    public static void main(String[] args) {
        System.out.println(calculateFibonacciLastDigit(sc.nextInt()));
        sc.close();
    }
}
