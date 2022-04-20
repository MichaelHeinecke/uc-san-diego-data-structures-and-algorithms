import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ExitFromMaze {
    static int checkForConnectionBetweenEntryAndExit(List<List<Integer>> adjacencyList, int mazeEntryVertex, int mazeExitVertex) {
        // use depth first search algorithm to traverse graph from mazeEntryVertex
        // if there is a path to mazeExitVertex, it will have been marked as visited after the traversal
        HashSet<Integer> visitedVertices = new HashSet<>();
        traverse(adjacencyList, visitedVertices, mazeEntryVertex);
        return visitedVertices.contains(mazeExitVertex)? 1 : 0;
    }

    private static void traverse(List<List<Integer>> adjacencyList, HashSet<Integer> visitedVertices, Integer currentVertex) {
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

        int mazeEntryVertex = scanner.nextInt() - 1;
        int mazeExitVertex = scanner.nextInt() - 1;

        System.out.println(checkForConnectionBetweenEntryAndExit(adjacencyList, mazeEntryVertex, mazeExitVertex));
    }
}
