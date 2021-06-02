import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumPairwiseProduct {
    static final Scanner sc = new Scanner(System.in);

    static long maximumPairwiseProduct(int[] array){
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        return (long) sortedArray[sortedArray.length - 1] * sortedArray[sortedArray.length - 2];
    }

    public static void main(String[] args) {
        int arrayLength = sc.nextInt();
        int[] inputArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            inputArray[i] = sc.nextInt();
        }

        System.out.println(maximumPairwiseProduct(inputArray));

        sc.close();
    }
}
