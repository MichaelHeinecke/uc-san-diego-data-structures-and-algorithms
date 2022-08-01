import java.util.*;

public class MinimumNumberOfFlightSegments {

    public static int determineDistanceBetweenNodes(List<List<Integer>> adjacencyList, int startNode, int destinationNode) {
        int[] distances = new int[adjacencyList.size()];
        // Queue for breadth first search containing starting node.
        Queue<Integer> bfsQueue = new LinkedList<>(List.of(startNode));

        while (!bfsQueue.isEmpty()) {
            // Iterate over neighbouring vertices.
            int nodeIndex = bfsQueue.remove();

            for (int neighbouringNodeIndex : adjacencyList.get(nodeIndex)) {
                // If visited previously, distance will not be equal to 0.
                if (distances[neighbouringNodeIndex] == 0) {
                    // Enqueue node index as reference to its neighbours.
                    bfsQueue.add(neighbouringNodeIndex);

                    distances[neighbouringNodeIndex] = distances[nodeIndex] + 1;
                    if (neighbouringNodeIndex == destinationNode) {
                        return distances[neighbouringNodeIndex];
                    }
                }
            }
        }

        // if destinationNode is not reachable in BFS, it's disconnected.
        return -1;
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
        int startNode = scanner.nextInt() - 1;
        int destinationNode = scanner.nextInt() - 1;
        System.out.println(determineDistanceBetweenNodes(adjacencyList, startNode, destinationNode));
    }

}
