import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BuildingRoadsToConnectCities {

    public static double calculateMinimumDistance(int[] xCoordinates, int[] yCoordinates) {
        // Implementation of Prim's algorithm
        // Distance from start vertex to vertex v
        double[] distances = new double[xCoordinates.length];
        // Initialize distances as infinity
        Arrays.fill(distances, Double.POSITIVE_INFINITY);
        // Distance from start vertex to start vertex is 0
        distances[0] = 0;

        // Create priority queue with cost as priority value
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        // Add start vertex
        priorityQueue.add(new Vertex(0, xCoordinates[0], yCoordinates[0], 0));

        // For each vertex starting from an arbitrary vertex, calculate the distance to each vertex that was not
        // visited yet and store the shortest distance.
        boolean[] visited = new boolean[xCoordinates.length];
        while (!priorityQueue.isEmpty()) {
            Vertex currentVertex = priorityQueue.poll();
            visited[currentVertex.vertexId] = true;

            for (int i = 0; i < xCoordinates.length; i++) {
                if (!visited[i]) {
                    double potentialDistance = Math.sqrt(
                            Math.pow(currentVertex.xCoordinate - xCoordinates[i], 2)
                            + Math.pow(currentVertex.yCoordinate - yCoordinates[i], 2)
                    );

                    if (potentialDistance < distances[i]) {
                        distances[i] = potentialDistance;
                        priorityQueue.add(new Vertex(i, xCoordinates[i], yCoordinates[i], distances[i]));
                    }
                }
            }

        }

        return Arrays.stream(distances).sum();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(calculateMinimumDistance(x, y));
    }

    static class Vertex implements Comparable<Vertex> {
        public int vertexId;
        public int xCoordinate;
        public int yCoordinate;
        public double cost;

        public Vertex(int vertexId, int xCoordinate, int yCoordinate, double cost) {
            this.vertexId = vertexId;
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex v) {
            return Double.compare(this.cost, v.cost);
        }

    }

}
