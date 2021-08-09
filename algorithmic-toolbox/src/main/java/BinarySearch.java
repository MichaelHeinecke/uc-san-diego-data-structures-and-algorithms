import java.util.Scanner;

public class BinarySearch {
    static final Scanner sc = new Scanner(System.in);

    public static int binarySearchIndexOfKey(int key, int[] sequence) {
        return binarySearch(key,sequence, 0, sequence.length);
    }

    private static int binarySearch(int key, int[] sequence, int lowIndex, int highIndex) {
        int midIndex = lowIndex + (highIndex - lowIndex) / 2;  // floor value

        if (highIndex < lowIndex || sequence.length <= midIndex) {
            return -1;
        }

        if (key == sequence[midIndex]) {
            return midIndex;
        } else if (key < sequence[midIndex]) {
            return binarySearch(key, sequence, lowIndex, midIndex - 1);
        } else {
            return binarySearch(key, sequence, midIndex + 1, highIndex);
        }
    }

    public static void main(String[] args) {
        int[] sequence = new int[sc.nextInt()];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = sc.nextInt();
        }

        int[] keys = new int[sc.nextInt()];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = sc.nextInt();
        }

        String[] indexes = new String[keys.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = String.valueOf(binarySearchIndexOfKey(keys[i], sequence));
        }

        System.out.println(String.join(" ", indexes));
    }
}
