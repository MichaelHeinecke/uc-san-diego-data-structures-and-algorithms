import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeterminingAnOrderOfCourses {

    static List<Integer> topologicalSort(List<List<Integer>> adjacencyList) {
        boolean[] vertexVisited = new boolean[adjacencyList.size()];
        List<Integer> order = new ArrayList<>();

        // perform DFS on every node in the graph
        for (int vertex = 0; vertex < adjacencyList.size(); vertex++) {
            // if vertex was not visited yet, start DFS
            if(!vertexVisited[vertex]) {
                vertexVisited[vertex] = true;
                topologicalSortUtil(adjacencyList, vertex, vertexVisited, order);
                // add vertex to order after visiting neighbours
                order.add(vertex);
            }
        }

        // last vertices in DFS are added first to order, hence order needs to be reversed
        Collections.reverse(order);
        return order;
    }

    private static void topologicalSortUtil(List<List<Integer>> adjacencyList, int vertex,
                                            boolean[] vertexVisited, List<Integer> order) {
        for (int neighbour : adjacencyList.get(vertex)) {
            // if vertex was not visited yet, visit its neighbours
            if(!vertexVisited[neighbour]) {
                vertexVisited[neighbour] = true;
                // visit neighbours of neighbour through recursive call
                topologicalSortUtil(adjacencyList, neighbour, vertexVisited, order);
                // add vertex to order after visiting neighbours
                order.add(neighbour);
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

        // add directed edges
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // vertex x has directed edge to vertex y
            adjacencyList.get(x - 1).add(y - 1);
        }

        List<Integer> order = topologicalSort(adjacencyList);
        // concatenate sorted vertices to print them
        String orderString = order.stream()
                .map(x -> x + 1)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(orderString);

        scanner.close();
    }
}
