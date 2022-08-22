import java.util.*;

public class MinimumCostOfFlight {

    public static long determineMinimumCostBetweenVertices(List<List<Integer>> adjacencyList, List<List<Integer>> costs,
                                                           int startVertex, int destinationVertex) {
        // Implementation of Dijkstra's algorithm

        // Distance from start vertex to vertex v
        long[] distances = new long[adjacencyList.size()];
        // Initialize distances as infinity
        Arrays.fill(distances, Long.MAX_VALUE);
        // Distance from start vertex to start vertex is 0
        distances[startVertex] = 0;

        // Create priority queue with distances as priority value
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        // Add start vertex to relax its edges
        priorityQueue.add(new Vertex(startVertex, 0));

        // Relax edges
        while (!priorityQueue.isEmpty()) {
            int currentVertexId = priorityQueue.poll().vertexId;
            List<Integer> adjacentVertices = adjacencyList.get(currentVertexId);
            List<Integer> adjacentCosts = costs.get(currentVertexId);

            for (int adjacencyIndex = 0; adjacencyIndex < adjacentVertices.size(); adjacencyIndex++) {
                int adjacentVertexId = adjacentVertices.get(adjacencyIndex);
                int adjacentCost = adjacentCosts.get(adjacencyIndex);

                // Relax edge if cost to reach it on current path is smaller than any previous paths
                if (distances[adjacentVertexId] > distances[currentVertexId] + adjacentCost) {
                    distances[adjacentVertexId] = distances[currentVertexId] + adjacentCost;
                    // Add adjacent vertex to relax its edges
                    priorityQueue.add(new Vertex(adjacentVertexId, distances[adjacentVertexId]));
                }
            }
        }

        // Minimum distance from source vertex to destination vertex or -1 if not reachable
        return distances[destinationVertex] != Long.MAX_VALUE ? distances[destinationVertex] : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of vertices
        int m = scanner.nextInt(); // Number of edges

        // Empty adjacency list and cost
        List<List<Integer>> adjacencyList = new ArrayList<>();
        List<List<Integer>> cost = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(i, new ArrayList<>());
            cost.add(i, new ArrayList<>());
        }

        // Add neighbouring vertices
        for (int i = 0; i < m; i++) {
            int x, y, c;
            x = scanner.nextInt();
            y = scanner.nextInt();
            c = scanner.nextInt();

            adjacencyList.get(x - 1).add(y - 1);
            cost.get(x - 1).add(c);
        }

        int startNode = scanner.nextInt() - 1;
        int destinationNode = scanner.nextInt() - 1;

        System.out.println(determineMinimumCostBetweenVertices(adjacencyList, cost, startNode, destinationNode));
    }

    static class Vertex implements Comparable<Vertex> {
        public int vertexId;
        public long cost;

        public Vertex(int vertexId, long cost) {
            this.vertexId = vertexId;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex v) {
            return Long.compare(this.cost, v.cost);
        }
    }

}
