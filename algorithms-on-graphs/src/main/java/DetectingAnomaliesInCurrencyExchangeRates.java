import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DetectingAnomaliesInCurrencyExchangeRates {

    public static int hasNegativeWeightCycle(List<List<Integer>> adjacencyList, List<List<Integer>> costs) {
        // Detect if a graph contains a negative weight cycle using the Bellman-Ford algorithm

        // Distances from start vertex to vertex v. Using a long array to prevent Integer overflow.
        long[] distances = new long[adjacencyList.size()];
        // Initialize distances as quasi-infinity
        Arrays.fill(distances, Integer.MAX_VALUE);
        // Distance from start vertex to start vertex is 0, starting with vertex with index 0
        distances[0] = 0;

        // Relax all edges |V| - 1 times as shortest path contains at most |V| − 1 edges and will be found after
        // |V| − 1 iterations.
        for (int count = 0; count < adjacencyList.size() - 1; count++) {
            // Iterate over edges from source vector u...
            for (int u = 0; u < adjacencyList.size(); u++) {
                // ...to destination vector v
                for (int j = 0; j < adjacencyList.get(u).size(); j++) {
                    int v = adjacencyList.get(u).get(j);
                    if (distances[v] > distances[u] + costs.get(u).get(j)) {
                        distances[v] = distances[u] + costs.get(u).get(j);
                    }
                }
            }
        }

        // Check for negative weight cycles by attempting to relax edges for the |V|th time. If any edge can be relaxed,
        // there's a negative weight cycle.
        for (int u = 0; u < adjacencyList.size(); u++) {
            for (int j = 0; j < adjacencyList.get(u).size(); j++) {
                int v = adjacencyList.get(u).get(j);
                if (distances[v] > distances[u] + costs.get(u).get(j)) {
                    return 1;
                }
            }
        }

        return 0;
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

        System.out.println(hasNegativeWeightCycle(adjacencyList, cost));
    }

}
