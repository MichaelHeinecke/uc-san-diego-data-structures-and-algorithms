import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeHeight {
    static public void main(String[] args) {
        try {
            new TreeHeight().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        Tree tree = new Tree();
        tree.read();
        tree.build();
        System.out.println(tree.computeHeight());
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

    public static class Tree {
        int n;
        int[] parent;
        Node[] nodes;
        int rootIndex = -1;  // initialize as -1 to indicate root is yet unknown or tree has no nodes after building

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
        }

        void build() {
            // create array of tree nodes
            nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node();
            }

            // add childIndexes to nodes and find index of root node
            for (int childIndex = 0; childIndex < n; childIndex++) {
                int parentIndex = parent[childIndex];

                if (parentIndex == -1) {
                    rootIndex = childIndex;
                } else {
                    nodes[parentIndex].addChildIndexes(nodes[childIndex]);
                }
            }
        }

        int computeHeight() {
            // height is computed by traversing the tree level by level and incrementing treeHeight at every level
            int treeHeight = 0;

            if (rootIndex == -1) {
                return treeHeight;
            }

            Queue<Node> levelTraversalQueue = new LinkedList<>();
            // enqueue root node
            levelTraversalQueue.add(nodes[rootIndex]);
            // traverse tree level by level
            while (!levelTraversalQueue.isEmpty()) {
                treeHeight++;
                Queue<Node> childNodes = new LinkedList<>();
                for (Node node : levelTraversalQueue) {
                    if (!node.getChildIndexes().isEmpty())
                        childNodes.addAll(node.getChildIndexes());
                }
                levelTraversalQueue.clear();
                levelTraversalQueue.addAll(childNodes);
            }

            return treeHeight;
        }

    }

    public static class Node {
        List<Node> childIndexes;

        Node() {
            childIndexes = new ArrayList<>();
        }

        public void addChildIndexes(Node childNode) {
            this.childIndexes.add(childNode);
        }

        public List<Node> getChildIndexes() {
            return childIndexes;
        }
    }
}
