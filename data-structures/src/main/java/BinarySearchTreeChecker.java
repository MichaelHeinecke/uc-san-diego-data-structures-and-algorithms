import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearchTreeChecker {
    static public void main(String[] args) {
        new Thread(null, () -> {
            try {
                new BinarySearchTreeChecker().run();
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

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static class BinaryTree {
        int numberOfNodes;
        Node[] tree;
        int keyOfPreviouslyVisitedNode = Integer.MIN_VALUE;

        BinaryTree() {
        }

        BinaryTree(Node[] tree) {
            this.tree = tree;
        }

        void read() throws IOException {
            FastScanner in = new FastScanner();
            numberOfNodes = in.nextInt();
            tree = new Node[numberOfNodes];
            for (int i = 0; i < numberOfNodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            if (tree.length == 0) {
                return true;
            }
            return isBinarySearchTreeUtil(tree[0]);
        }

        private boolean isBinarySearchTreeUtil(Node node) {
            // check tree with in order traversal keeping track of the previously visited node's key

            // recursive call to check whether left sub-tree is binary search tree
            if (node.getLeftChildIndex() != -1 && !isBinarySearchTreeUtil(tree[node.getLeftChildIndex()])) {
                return false;
            }

            /* if key of previously visited note is larger than or equal to the current note's key
            the tree is not a binary search tree */
            if (keyOfPreviouslyVisitedNode >= node.getKey()) {
                return false;
            }

            keyOfPreviouslyVisitedNode = node.getKey();

            // recursive call to check whether right sub-tree is binary search tree
            if (node.getRightChildIndex() != -1) {
                return isBinarySearchTreeUtil(tree[node.getRightChildIndex()]);
            }

            return true;
        }

        static class Node {
            private final int key;
            private final int leftChildIndex;
            private final int rightChildIndex;

            Node(int key, int left, int right) {
                this.leftChildIndex = left;
                this.rightChildIndex = right;
                this.key = key;
            }

            int getKey() {
                return key;
            }

            int getLeftChildIndex() {
                return leftChildIndex;
            }

            int getRightChildIndex() {
                return rightChildIndex;
            }
        }
    }

}
