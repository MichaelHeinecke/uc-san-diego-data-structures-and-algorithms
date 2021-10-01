import java.util.Scanner;

public class MaximumAmountOfGoldDiscreteKnapsack {
    final static Scanner scanner = new Scanner(System.in);

    static int determineMaximumAmountOfGold(int totalCapacity, int[] barsOfGold) {
        int[][] knapsack = new int[barsOfGold.length + 1][totalCapacity + 1];

        for (int goldBarIndex = 1; goldBarIndex <= barsOfGold.length; goldBarIndex++) {
            for (int capacity = 1; capacity <= totalCapacity; capacity++) {
                knapsack[goldBarIndex][capacity] = knapsack[goldBarIndex - 1][capacity];
                if (barsOfGold[goldBarIndex - 1] <= capacity) {
                    int value = knapsack[goldBarIndex - 1][capacity - barsOfGold[goldBarIndex - 1]]
                            + barsOfGold[goldBarIndex - 1];
                    if (knapsack[goldBarIndex][capacity] < value) {
                        knapsack[goldBarIndex][capacity] = value;
                    }
                }
            }
        }

        return knapsack[barsOfGold.length][totalCapacity];
    }

    public static void main(String[] args) {
        int knapsackCapacity = scanner.nextInt();
        int numberOfGoldBars = scanner.nextInt();
        int[] weightsOfGoldBars = new int[numberOfGoldBars + 1];
        for (int i = 0; i < numberOfGoldBars; i++) {
            weightsOfGoldBars[i] = scanner.nextInt();
        }
        System.out.println(determineMaximumAmountOfGold(knapsackCapacity, weightsOfGoldBars));
    }
}



