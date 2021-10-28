import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BinarySearchTreeCheckerNonDistinctElements {
    static public void main(String[] args) {
        new Thread(null, () -> {
            try {
                new BinarySearchTreeCheckerNonDistinctElements().run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        BinaryTree tree = new BinaryTree();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }

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

        int nexInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static class BinaryTree {
        int numberOfNodes;
        Map<Integer, int[]> tree = new HashMap<>();

        BinaryTree() {}

        BinaryTree(Map<Integer, int[]> tree) {
            this.tree = tree;
        }

        void read() throws IOException {
            FastScanner in = new FastScanner();
            numberOfNodes = in.nexInt();
            for (int i = 0; i < numberOfNodes; i++) {
                tree.put(i, new int[]{in.nexInt(), in.nexInt(), in.nexInt()});
            }
        }

        boolean isBinarySearchTree() {
            if (tree.size() == 0) {
                return true;
            }
            return isBinarySearchTreeUtil(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean isBinarySearchTreeUtil(int nodeIndex, int minKey, int maxKey) {
            if (!tree.containsKey(nodeIndex)) {
                return true;
            }


            if (tree.get(nodeIndex)[0] < minKey || tree.get(nodeIndex)[0] > maxKey) {
                return false;
            }
            // recursive calls to check left and right sub-tree under current node
            return isBinarySearchTreeUtil(tree.get(nodeIndex)[1], minKey, tree.get(nodeIndex)[0] - 1)
                    && isBinarySearchTreeUtil(tree.get(nodeIndex)[2], tree.get(nodeIndex)[0], maxKey);
        }
    }
}
