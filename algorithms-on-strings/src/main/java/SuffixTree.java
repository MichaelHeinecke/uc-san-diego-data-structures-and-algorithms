import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SuffixTree {

    private final SuffixTreeNode root;

    public SuffixTree(String text) {
        this.root = new SuffixTreeNode("ROOT");
        this.root.children.put(text.charAt(0), new SuffixTreeNode(text));

        // Iterate over suffixes
        for (int i = 1; i < text.length(); i++) {
            SuffixTreeNode currentNode = this.root;

            // Traverse the tree until there are no more label matches
            for (int j = i; j < text.length(); ) {
                // Child node for suffix exists
                if (currentNode.children.containsKey(text.charAt(j))) {
                    SuffixTreeNode childNode = currentNode.children.get(text.charAt(j));
                    String label = childNode.label;

                    // Traverse edges for the length of the label or until character mismatches
                    int k = j + 1;
                    while (k - j < label.length() && text.charAt(k) == label.charAt(k - j)) {
                        k = k + 1;
                    }

                    if (k - j == label.length()) { // Exhausted label length -> Complete match; add new leaf
                        currentNode = childNode;
                        j = k;
                    } else { // Label is only partial match -> Split label for non-matching part into remainder child nodes
                        SuffixTreeNode splitNode = new SuffixTreeNode(label.substring(0, k - j));
                        SuffixTreeNode suffixRemainderNew = new SuffixTreeNode(text.substring(k));
                        splitNode.children.put(text.charAt(k), suffixRemainderNew);

                        // Current child becomes splitNode's child
                        childNode.label = label.substring(k - j);
                        splitNode.children.put(label.charAt(k - j), childNode);

                        // splitNode becomes child of original parent
                        currentNode.children.put(text.charAt(j), splitNode);
                    }
                } else { // No child node for suffix with (partial) match exists or leaf reached -> Add new leaf
                    currentNode.children.put(text.charAt(j), new SuffixTreeNode(text.substring(j)));
                }
            }
        }
    }

    static public void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        SuffixTree suffixTree = new SuffixTree(text);
        List<String> edges = suffixTree.computeSuffixTreeEdges();
        edges.forEach(System.out::println);
    }

    // Build a suffix tree of the string text and return a list
    // with all the labels of its edges (the corresponding
    // substrings of the text) in any order.
    public List<String> computeSuffixTreeEdges() {
        List<String> result = new ArrayList<>();

        Queue<SuffixTreeNode> queue = new ArrayDeque<>(this.root.children.values());
        while (!queue.isEmpty()) {
            SuffixTreeNode currentNode = queue.poll();
            result.add(currentNode.label);
            queue.addAll(currentNode.children.values());
        }

        return result;
    }

    private static class SuffixTreeNode {
        String label;
        Map<Character, SuffixTreeNode> children;

        public SuffixTreeNode(String label) {
            this.label = label;
            this.children = new HashMap<>();
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

    }
}
