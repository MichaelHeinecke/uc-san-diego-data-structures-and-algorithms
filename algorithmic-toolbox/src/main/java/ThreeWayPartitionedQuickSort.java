import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class ThreeWayPartitionedQuickSort {

    private static final Random random = new Random();

    private static void swap(int[] array, int element1, int element2) {
        int temp = array[element1];
        array[element1] = array[element2];
        array[element2] = temp;
    }

    private static int[] partition3(int[] a, int l, int r) {
        int m1 = l - 1;
        int m2 = r;
        int p = l - 1;
        int q = r;
        int v = a[r];

        while (true) {
            while (a[++m1] < v) ;

            while (v < a[--m2]) {
                if (m2 == l)
                    break;
            }

            if (m1 >= m2) {
                break;
            }

            swap(a, m1, m2);

            if (a[m1] == v) {
                p++;
                swap(a, m1, p);
            }

            if (a[m2] == v) {
                q--;
                swap(a, q, m2);
            }
        }

        swap(a, m1, r);

        m2 = m1 - 1;
        for (int k = l; k < p; k++, m2--) {
            swap(a, k, m2);
        }

        m1 = m1 + 1;
        for (int k = r - 1; k > q; k--, m1++) {
            swap(a, m1, k);
        }

        return new int[]{m1, m2};
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    public static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;

        //int m = partition2(a, l, r);
        //randomizedQuickSort(a, l, m - 1);
        //randomizedQuickSort(a, m + 1, r);

        //use partition3
        int[] partitionIndexes = partition3(a, l, r);
        randomizedQuickSort(a, l, partitionIndexes[1]);
        randomizedQuickSort(a, partitionIndexes[0], r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
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
