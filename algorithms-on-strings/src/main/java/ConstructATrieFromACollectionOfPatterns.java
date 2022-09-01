import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConstructATrieFromACollectionOfPatterns {

    private static final int ROOT = 0;

    static public void main(String[] args) throws IOException {
        new ConstructATrieFromACollectionOfPatterns().run();
    }

    List<Map<Character, Integer>> buildTrie(String[] patterns) {
        List<Map<Character, Integer>> trie = new ArrayList<>();
        trie.add(new HashMap<>());

        for (String pattern : patterns) {
            int currentNode = ROOT;
            for (char c : pattern.toCharArray()) {
                // Get child node index if child with label c exists on current node or insert new leaf node
                // and return its index
                currentNode = trie.get(currentNode).computeIfAbsent(c, node -> {
                    int nextNode = trie.size();
                    trie.add(new HashMap<>());
                    return nextNode;
                });
            }
        }

        return trie;
    }

    public void print(List<Map<Character, Integer>> trie) {
        for (int i = 0; i < trie.size(); ++i) {
            Map<Character, Integer> node = trie.get(i);
            for (Map.Entry<Character, Integer> entry : node.entrySet()) {
                System.out.println(i + "->" + entry.getValue() + ":" + entry.getKey());
            }
        }
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        int patternsCount = scanner.nextInt();
        String[] patterns = new String[patternsCount];
        for (int i = 0; i < patternsCount; ++i) {
            patterns[i] = scanner.next();
        }
        List<Map<Character, Integer>> trie = buildTrie(patterns);
        print(trie);
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

}
