import java.util.*;
import java.io.*;

public class TreeOrder {
    static class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static class TreeOrders {
        int n;
        int[] key, left, right;

        TreeOrders () {}

        TreeOrders (int n, int[] key, int[] left, int[] right) {
            this.n = n;
            this.key = key;
            this.left = left;
            this.right = right;
        }

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            key = new int[n];
            left = new int[n];
            right = new int[n];
            for (int i = 0; i < n; i++) {
                key[i] = in.nextInt();
                left[i] = in.nextInt();
                right[i] = in.nextInt();
            }
        }

        List<Integer> inOrder() {
            ArrayList<Integer> result = new ArrayList<>();
            walkTreeInOrder(result, 0);
            return result;
        }

        private void walkTreeInOrder(List<Integer> result, int indexOfCurrentVertex) {
            int leftChild = left[indexOfCurrentVertex];
            int rightChild = right[indexOfCurrentVertex];

            if (leftChild != -1) {
                walkTreeInOrder(result, leftChild);
            }

            result.add(key[indexOfCurrentVertex]);

            if (rightChild != -1) {
                walkTreeInOrder(result, rightChild);
            }
        }


        List<Integer> preOrder() {
            ArrayList<Integer> result = new ArrayList<>();
            walkTreePreOrder(result, 0);
            return result;
        }

        private void walkTreePreOrder(List<Integer> result, int indexOfCurrentVertex) {
            int leftChild = left[indexOfCurrentVertex];
            int rightChild = right[indexOfCurrentVertex];

            result.add(key[indexOfCurrentVertex]);

            if (leftChild != -1) {
                walkTreePreOrder(result, leftChild);
            }

            if (rightChild != -1) {
                walkTreePreOrder(result, rightChild);
            }
        }

        List<Integer> postOrder() {
            ArrayList<Integer> result = new ArrayList<>();
            walkTreePostOrder(result, 0);
            return result;
        }

        private void walkTreePostOrder(List<Integer> result, int indexOfCurrentVertex) {
            int leftChild = left[indexOfCurrentVertex];
            int rightChild = right[indexOfCurrentVertex];

            if (leftChild != -1) {
                walkTreePostOrder(result, leftChild);
            }

            if (rightChild != -1) {
                walkTreePostOrder(result, rightChild);
            }

            result.add(key[indexOfCurrentVertex]);
        }
    }

    static public void main(String[] args) {
        new Thread(null, () -> {
            try {
                new TreeOrder().run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "1", 1 << 26).start();
    }

    public void print(List<Integer> x) {
        for (Integer a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        TreeOrders tree = new TreeOrders();
        tree.read();
        print(tree.inOrder());
        print(tree.preOrder());
        print(tree.postOrder());
    }
}
