import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class MultiplePatternMatching {

    private static final int ROOT = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String text = in.readLine();
            int n = Integer.parseInt(in.readLine());
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = in.readLine();
            }

            List<Integer> ans = trieMatch(text, patterns);

            System.out.println(ans.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    static List<Map<Character, Integer>> buildTrie(String[] patterns) {
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

    static List<Integer> trieMatch(String text, String[] patterns) {
        List<Integer> results = new ArrayList<>();
        List<Map<Character, Integer>> trie = buildTrie(patterns);

        for (int startIndex = 0; startIndex < text.length(); startIndex++) {
            int currentNode = ROOT;

            for (char symbol : text.substring(startIndex).toCharArray()) {
                // If node has an edge labeled with symbol, follow that edge.
                if (trie.get(currentNode).containsKey(symbol)) {
                    currentNode = trie.get(currentNode).get(symbol);
                    // If currentNode is a leaf, pattern was matched. Add start index of match in text to results.
                    if (trie.get(currentNode).isEmpty()) {
                        results.add(startIndex);
                        break;
                    }
                // No edge to follow - no match found.
                } else {
                    break;
                }
            }
        }

        return results;
    }

}
