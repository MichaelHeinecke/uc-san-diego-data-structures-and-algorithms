import java.util.Scanner;

public class MoneyChange {
    static final Scanner sc = new Scanner(System.in);

    // constraint: 1 ≤ 𝑚 ≤ 103
    public static int calculateNumberOfCoins(int m) {
        int numberOfTens = m / 10;
        int remainder = m % 10;
        int numberOfFives = remainder / 5;
        int numberOfOnes = remainder % 5;

        return numberOfTens + numberOfFives + numberOfOnes;
    }

    public static void main(String[] args) {
        System.out.println(calculateNumberOfCoins(sc.nextInt()));
        sc.close();
    }
}
