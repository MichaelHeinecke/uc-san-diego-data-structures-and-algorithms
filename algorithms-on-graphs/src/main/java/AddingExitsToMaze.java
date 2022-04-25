import java.util.*;

public class AddingExitsToMaze {
    static int findNumberOfConnectedComponents(List<List<Integer>> adjacencyList) {
        // use depth first search algorithm to traverse graph
        Set<Integer> visitedVertices = new HashSet<>();
        int numberOfConnectedComponents = 0;

        // iterate over adjacency list for starting points of traversals
        for (int vertex = 0; vertex < adjacencyList.size(); vertex++) {
            // if starting point was not previously visited, it'll be an additional component in the graph
            if (!visitedVertices.contains(vertex)) {
                numberOfConnectedComponents++;
                traverse(adjacencyList, visitedVertices, vertex);
            }
        }

        return numberOfConnectedComponents;
    }

    private static void traverse(List<List<Integer>> adjacencyList, Set<Integer> visitedVertices, Integer currentVertex) {
        // mark current vertex as visited
        visitedVertices.add(currentVertex);

        // recursive call to traverse method for all adjacent vertices of current vertex
        for (Integer vertex : adjacencyList.get(currentVertex)) {
            if (!visitedVertices.contains(vertex)) {
                traverse(adjacencyList, visitedVertices, vertex);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // number of vertices
        int m = scanner.nextInt(); // number of edges

        // empty adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }

        // add neighbouring vertices
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();

            List<Integer> temp = adjacencyList.get(x - 1);
            temp.add(y - 1);
            adjacencyList.set(x - 1, temp);

            temp = adjacencyList.get(y - 1);
            temp.add(x - 1);
            adjacencyList.set(y - 1, temp);
        }

        System.out.println(findNumberOfConnectedComponents(adjacencyList));
    }
}
