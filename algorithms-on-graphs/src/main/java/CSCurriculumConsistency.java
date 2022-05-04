import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSCurriculumConsistency {
    static int isAcyclic(List<List<Integer>> adjacencyList) {
        // use DFS to traverse graph while keeping track of visited vertices and vertices in the stack
        // mark all the vertices as not visited and not part of recursion stack
        boolean[] visitedVertices = new boolean[adjacencyList.size()];
        boolean[] recursionStack = new boolean[adjacencyList.size()];

        // iterate over all vertices in graph and do DFS on the subtrees
        for (int vertex = 0; vertex < adjacencyList.size(); vertex++)
            if (isAcyclicUtil(adjacencyList, vertex, visitedVertices, recursionStack)) {
                return 1;
            }

        return 0;
    }

    private static boolean isAcyclicUtil(List<List<Integer>> adjacencyList, int vertex,
                                         boolean[] visitedVertices, boolean[] recursionStack) {
        // if the current vertex is already on the stack, we discovered a back edge
        if (recursionStack[vertex]) {
            return true;
        }

        // if the current vertex is not currently on the stack but was visited previously,
        // we already checked this subtree for back edges and there is no need to do it again
        if (visitedVertices[vertex]) {
            return false;
        }

        // mark the current node as visited and part of recursion stack
        visitedVertices[vertex] = true;
        recursionStack[vertex] = true;

        List<Integer> neighbours = adjacencyList.get(vertex);
        for (Integer neighbour : neighbours)
            if (isAcyclicUtil(adjacencyList, neighbour, visitedVertices, recursionStack)) {
                return true;
            }

        // mark vertex as not on stack before stepping out of method to previous vertex
        recursionStack[vertex] = false;

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // empty adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }

        // add directed edges
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // vertex x has directed edge to vertex y
            adjacencyList.get(x - 1).add(y - 1);
        }

        System.out.println(isAcyclic(adjacencyList));
    }
}

