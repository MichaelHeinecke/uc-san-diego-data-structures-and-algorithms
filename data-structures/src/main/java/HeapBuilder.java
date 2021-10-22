import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HeapBuilder {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    HeapBuilder() {
    }

    HeapBuilder(int[] data) {
        this.data = data;
    }

    public static void main(String[] args) throws IOException {
        new HeapBuilder().solve();
    }

    public List<Swap> getSwaps() {
        return swaps;
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
            data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
            out.println(swap.index1 + " " + swap.index2);
        }
    }

    void generateSwaps() {
        new Heap(data);
        swaps = Heap.getSwaps();
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static class Heap {
        private static final List<Swap> swaps = new ArrayList<>();
        private static int size;
        private static int[] array;

        Heap(int[] array) {
            Heap.size = array.length;
            Heap.array = array;
            for (int i = size / 2 - 1; i >= 0; i--) {
                siftDown(i);
            }
        }

        static List<Swap> getSwaps() {
            return swaps;
        }

        static int getLeftChild(int i) {
            return 2 * i + 1;
        }

        static int getRightChild(int i) {
            return 2 * i + 2;
        }

        private void swap(int element1, int element2) {
            swaps.add(new Swap(element1, element2));
            int tmp = array[element1];
            array[element1] = array[element2];
            array[element2] = tmp;
        }

        private void siftDown(int i) {
            int minIndex = i;
            int left = getLeftChild(i);

            // Check whether left child is in array bounds and smaller than array element at i
            if (left < size && array[left] < array[minIndex]) {
                minIndex = left;
            }

            // Check whether right child is in array bounds and smaller than array element at i
            int right = getRightChild(i);
            if (right < size && array[right] < array[minIndex]) {
                minIndex = right;
            }

            if (i != minIndex) {
                swap(i, minIndex);
                siftDown(minIndex);
            }
        }
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }

        @Override
        public boolean equals(Object o) {
            // If the object is compared with itself then return true
            if (o == this) {
                return true;
            }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
            if (!(o instanceof Swap)) {
                return false;
            }

            // typecast o to swap to compare fields
            Swap s = (Swap) o;

            // Compare the fields and return accordingly
            return index1 == s.index1 && index2 == s.index2;
        }
    }

}
