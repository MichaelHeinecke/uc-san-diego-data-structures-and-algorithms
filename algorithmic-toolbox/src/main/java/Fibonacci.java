import java.util.Scanner;

public class Fibonacci {
    static final Scanner sc = new Scanner(System.in);

    public static int calculateFibonacci(int n) {
        // constraint: 0 <= n <= 45

        if (n <= 1) {
            return n;
        }

        int[] fibonacciNumbers = new int[n + 1];
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;

        for (int idx = 2; idx <= n; idx++) {
            fibonacciNumbers[idx] = fibonacciNumbers[idx - 1] + fibonacciNumbers[idx - 2];
        }

        return fibonacciNumbers[n];
    }

    public static void main(String[] args) {
        System.out.println(calculateFibonacci(sc.nextInt()));
        sc.close();
    }
}
