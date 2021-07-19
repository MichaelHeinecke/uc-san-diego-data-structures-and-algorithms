import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MaximumValueOfLoot {
    static final Scanner sc = new Scanner(System.in);

    public static double calculateMaximumValueOfLoot(int knapsackCapacity, Map<Double, Integer> worthAmount) {
        double lootValue = 0;

        for (Map.Entry<Double, Integer> entry : worthAmount.entrySet()) {
            if (entry.getValue() <= knapsackCapacity) {
                lootValue += entry.getKey() * entry.getValue();
                knapsackCapacity -= entry.getValue();
            } else {
                lootValue += entry.getKey() * knapsackCapacity;
                return lootValue;
            }
        }
        return lootValue;
    }

    public static void main(String[] args) {
        int numberOfLootItems = sc.nextInt();
        int knapsackCapacity = sc.nextInt();
        Map<Double, Integer> worthAmount = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < numberOfLootItems; i++) {
            int value = sc.nextInt();
            int amount = sc.nextInt();
            worthAmount.put(value / (double) amount, amount);
        }

        System.out.printf("%.4f%n", calculateMaximumValueOfLoot(knapsackCapacity, worthAmount));
    }
}
