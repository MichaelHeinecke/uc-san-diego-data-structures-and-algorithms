import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GeneralizedMultiplePatternMatching {
        private final TrieNode ROOT = new TrieNode('^', false, new HashMap<>());

        void buildTrie(String[] patterns) {
            for (String pattern : patterns) {
                TrieNode currentNode = ROOT;
                for (int i = 0; i < pattern.length(); i++) {
                    char c = pattern.charAt(i);
                    // Get child node index if child with label c exists on current node or insert new leaf node
                    // and return its index
                    currentNode = currentNode.getChildren().computeIfAbsent(c, node -> new TrieNode(c, false, new HashMap<>()));
                }
                currentNode.setEndOfPattern(true);
            }
        }

        List<Integer> findMatches(String text) {
            List<Integer> results = new ArrayList<>();

            for (int startIndex = 0; startIndex < text.length(); startIndex++) {
                TrieNode currentNode = ROOT;

                for (char symbol : text.substring(startIndex).toCharArray()) {
                    // If node has an edge labeled with symbol, follow that edge.
                    if (currentNode.getChildren().containsKey(symbol)) {
                        currentNode = currentNode.getChildren().get(symbol);
                        // If currentNode is a leaf, pattern was matched. Add start index of match in text to results.
                        if (currentNode.getChildren().isEmpty() || currentNode.isEndOfPattern()) {
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

    private static class TrieNode {
        char label;
        boolean isEndOfPattern;
        Map<Character, TrieNode> children;

        public TrieNode(char label, boolean isEndOfPattern, Map<Character, TrieNode> children) {
            this.label = label;
            this.isEndOfPattern = isEndOfPattern;
            this.children = children;
        }

        public boolean isEndOfPattern() {
            return isEndOfPattern;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public void setEndOfPattern(boolean endOfPattern) {
            isEndOfPattern = endOfPattern;
        }
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String text = in.readLine();
            int n = Integer.parseInt(in.readLine());
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = in.readLine();
            }

            GeneralizedMultiplePatternMatching generalizedMultiplePatternMatching = new GeneralizedMultiplePatternMatching();
            generalizedMultiplePatternMatching.buildTrie(patterns);
            List<Integer> ans = generalizedMultiplePatternMatching.findMatches(text);

            System.out.println(ans.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

}
