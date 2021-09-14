import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {
    final static Scanner scanner = new Scanner(System.in);

    static List<Integer> determineOptimalSequence(int inputNumber) {
        int[] minimumOperations = new int[inputNumber + 1];

        // Determine minimum number of operations for each number from 1 up to inputNumber
        for (int currentNumber = 1; currentNumber < minimumOperations.length; currentNumber++) {
            minimumOperations[currentNumber] = minimumOperations[currentNumber - 1] + 1;

            if (currentNumber % 2 == 0) {
                minimumOperations[currentNumber] = Math.min(
                        1 + minimumOperations[currentNumber / 2], minimumOperations[currentNumber]
                );
            }

            if (currentNumber % 3 == 0) {
                minimumOperations[currentNumber] = Math.min(
                        1 + minimumOperations[currentNumber / 3], minimumOperations[currentNumber]
                );
            }
        }

        // Trace optimal sequence of operations from inputNumber down to starting number 1
        List<Integer> optimalSequence = new ArrayList<>();
        for (int currentNumber = inputNumber; currentNumber > 1; ) {
            optimalSequence.add(currentNumber);
            if (minimumOperations[currentNumber - 1] == minimumOperations[currentNumber] - 1) {
                currentNumber = currentNumber - 1;
            } else if (currentNumber % 2 == 0
                    && (minimumOperations[currentNumber / 2] == minimumOperations[currentNumber] - 1)) {
                currentNumber /= 2;
            } else if (currentNumber % 3 == 0
                    && (minimumOperations[currentNumber / 3] == minimumOperations[currentNumber] - 1)) {
                currentNumber /= 3;
            }
        }

        optimalSequence.add(1);

        Collections.reverse(optimalSequence);
        return optimalSequence;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        List<Integer> sequence = determineOptimalSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
        scanner.close();
    }
}
