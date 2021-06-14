import java.util.Scanner;

public class FibonacciPisanoPeriod {
    static final Scanner sc = new Scanner(System.in);

    public static long calculateFibonacciModulo(long n, int m) {
        // constraints 1 ≤ 𝑛 ≤ 10^14, 2 ≤ 𝑚 ≤ 10^3
        n = n % calculateLengthOfPisanoPeriod(m);

        long previous = 0;
        long current = 1;

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        for (int i = 0; i < n - 1; i++) {
            long temp;
            temp = current;
            current = (previous + current) % m;
            previous = temp;
        }
        return current % m;
    }

    public static int calculateLengthOfPisanoPeriod(int m) {
        int lengthOfPisanoPeriod = 0;
        int previous = 0;
        int current = 1;

        for (int i = 0; i < m * m; i++) {
            int temp;
            temp = current;
            current = (previous + current) % m;
            previous = temp;

            if (previous == 0 && current == 1)
                lengthOfPisanoPeriod = ++i;
        }
        return lengthOfPisanoPeriod;
    }

    public static void main(String[] args) {
        System.out.println(calculateFibonacciModulo(sc.nextLong(), sc.nextInt()));
        sc.close();
    }
}
