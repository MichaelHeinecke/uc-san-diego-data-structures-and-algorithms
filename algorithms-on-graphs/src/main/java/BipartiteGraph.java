import java.util.*;
import java.util.stream.IntStream;

public class BipartiteGraph {

    public static int isBipartite(List<List<Integer>> adjacencyList) {
        // Colour neighbouring nodes switching between red and black. If neighbouring nodes end up with the same colour,
        // the graph is not bipartite.
        NodeColour[] nodeColours = new NodeColour[adjacencyList.size()];
        IntStream.range(0, adjacencyList.size()).forEach(i -> nodeColours[i] = NodeColour.UNSET);

        // Iterate over all nodes as starting nodes to check disconnected parts of the graph.
        for (int i = 0; i < adjacencyList.size(); i++) {
            // Check if node was already visited previously and traverse with BFS if not.
            if (nodeColours[i] == NodeColour.UNSET) {
                // Queue for breadth first search containing starting node.
                Queue<Integer> bfsQueue = new LinkedList<>(Arrays.asList(i));

                while (!bfsQueue.isEmpty()) {
                    // Iterate over neighbouring vertices.
                    int nodeIndex = bfsQueue.remove();

                    for (int neighbouringNodeIndex : adjacencyList.get(nodeIndex)) {
                        // If not visited previously, colour will be unset.
                        if (nodeColours[neighbouringNodeIndex].equals(NodeColour.UNSET)) {
                            // Enqueue node index as reference to its neighbours.
                            bfsQueue.add(neighbouringNodeIndex);
                            // Colour neighbouring node with opposite colour.
                            NodeColour colour = nodeColours[nodeIndex] == NodeColour.BLACK ? NodeColour.RED : NodeColour.BLACK;
                            nodeColours[neighbouringNodeIndex] = colour;
                        }
                        // If colours of node and neighbouring node match, the graph is not bipartite.
                        else if (nodeColours[nodeIndex] == nodeColours[neighbouringNodeIndex]) {
                            return 0;
                        }
                    }
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of vertices
        int m = scanner.nextInt(); // Number of edges

        // Empty adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }

        // Add neighbouring vertices
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();

            adjacencyList.get(x - 1).add(y - 1);
            adjacencyList.get(y - 1).add(x - 1);
        }
        scanner.close();

        System.out.println(isBipartite(adjacencyList));
    }

    private enum NodeColour {
        UNSET, BLACK, RED
    }

}
