import java.util.Arrays;
import java.util.Scanner;

class PartitioningSouvenirs {
    final static Scanner scanner = new Scanner(System.in);

    // returns true if the given arrayToPartition can be split so that the sub-partition sums are equal
    public static boolean subPartitionSum(int[] arrayToPartition, int n, int a, int b, int c) {
        // return true if equal sub-partitioning is found
        if (a == 0 && b == 0 && c == 0) {
            return true;
        }

        // base case: no items left
        if (n < 0) {
            return false;
        }

        // case A: The current item becomes part of the first subset
        boolean A = false;
        if (a - arrayToPartition[n] >= 0) {
            A = subPartitionSum(arrayToPartition, n - 1, a - arrayToPartition[n], b, c);
        }

        // case B: The current item becomes part of the second subset
        boolean B = false;
        if (!A && (b - arrayToPartition[n] >= 0)) {
            B = subPartitionSum(arrayToPartition, n - 1, a, b - arrayToPartition[n], c);
        }

        // case C: The current item becomes part of the third subset
        boolean C = false;
        if ((!A && !B) && (c - arrayToPartition[n] >= 0)) {
            C = subPartitionSum(arrayToPartition, n - 1, a, b, c - arrayToPartition[n]);
        }

        // return true if we get a solution
        return A || B || C;
    }

    // wrapper function for solving the three-way partitioning problem
    // returns true if the given array can be divided into three partitions with an equal sum
    public static boolean checkThreeWayPartitioningPossible(int[] arrayToPartition) {
        if (arrayToPartition.length < 3) {
            return false;
        }

        // sum of all elements in the set
        int sum = Arrays.stream(arrayToPartition).sum();

        // return true if the sum is divisible by 3 and the arrayToPartition can
        // be divided into three partitions with an equal sum
        return (sum % 3) == 0 && subPartitionSum(arrayToPartition, arrayToPartition.length - 1, sum / 3, sum / 3, sum / 3);
    }

    public static void main(String[] args) {
        int numberOfSouvenirs = scanner.nextInt();
        int[] souvenirs = new int[numberOfSouvenirs];

        for (int souvenirIndex = 0; souvenirIndex < souvenirs.length; souvenirIndex++) {
            souvenirs[souvenirIndex] = scanner.nextInt();
        }

        int result = checkThreeWayPartitioningPossible(souvenirs) ? 1 : 0;
        System.out.println(result);

        scanner.close();
    }
}