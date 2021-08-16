import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MajorityElement {
    static final FastScanner sc = new FastScanner(System.in);

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

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
