import java.util.Scanner;

public class MoneyChangeDynamicProgramming {

    final static Scanner scanner = new Scanner(System.in);

    static int calculateMinimumNumberOfCoins(int moneyValue) {
        // minimumNumberOfCoinsPerMoneyValue[i] will be storing
        // the minimum number of coins required for moneyValue i.
        // So minimumNumberOfCoinsPerMoneyValue[moneyValue] will be the result
        int[] minimumNumberOfCoinsPerMoneyValue = new int[moneyValue + 1];

        // Possible coin denominations: 1, 3, 4
        int[] coins = new int[]{1, 3, 4};

        // Base case moneyValue equal to 0
        minimumNumberOfCoinsPerMoneyValue[0] = 0;

        // Initialize all minimumNumberOfCoinsPerMoneyValue values as Integer.MAX_VALUE
        for (int i = 1; i <= moneyValue; i++) {
            minimumNumberOfCoinsPerMoneyValue[i] = Integer.MAX_VALUE;
        }

        // Compute minimum coins required for all values from 1 to moneyValue
        for (int value = 1; value <= moneyValue; value++)
        {
            // Go through all coins smaller than or equal to value
            for (int coin : coins)
                if (coin <= value) {
                    int subRes = minimumNumberOfCoinsPerMoneyValue[value - coin];
                    if (subRes + 1 < minimumNumberOfCoinsPerMoneyValue[value]) {
                        minimumNumberOfCoinsPerMoneyValue[value] = subRes + 1;
                    }
                }
        }

        return minimumNumberOfCoinsPerMoneyValue[moneyValue];
    }

    public static void main(String[] args) {
        int money = scanner.nextInt();
        System.out.println(calculateMinimumNumberOfCoins(money));
        scanner.close();
    }
}
