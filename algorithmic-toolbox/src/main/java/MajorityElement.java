import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {
    static final Scanner sc = new Scanner(System.in);

    public static int findMajorityElement(int[] array) {
        Arrays.sort(array);  // O(n log n)

        int count = 1;
        int maximumElementCount = -1;
        int temp = array[0];
        int hasMajorityElement = 0;

        for (int i = 1; i < array.length; i++) {
            if (temp == array[i]) {
                count++;
            } else {
                count = 1;
                temp = array[i];
            }

            if (maximumElementCount < count) {
                maximumElementCount = count;

                if (maximumElementCount > (array.length / 2)) {
                    hasMajorityElement = 1;
                    break;
                }
            }
        }

        return hasMajorityElement;
    }

    public static void main(String[] args) {
        int[] array = new int[sc.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(findMajorityElement(array));
    }
}
