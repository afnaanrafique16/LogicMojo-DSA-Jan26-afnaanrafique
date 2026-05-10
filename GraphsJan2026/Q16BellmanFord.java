package src.GraphsJan2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q16BellmanFord {

    // Class to store edges
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Bellman Ford Algorithm
    public static int[] bellmanFord(int n, List<Edge> edges, int source) {

        int[] dist = new int[n];

        // Initially all distances are infinity
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance to source is 0
        dist[source] = 0;

        // Relax all edges (n-1) times (V times = > no of nodes times)
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {

                int u = edge.src;
                int v = edge.dest;
                int w = edge.weight;

                /*
                u => source
                v => destination
                 */
                // Relaxation step
                if (dist[u] != Integer.MAX_VALUE &&
                        dist[u] + w < dist[v]) {

                    dist[v] = dist[u] + w;
                }
            }
        }

        /*
        If at relaxing nth time the values are changing => there is a negative
        edge cycle. => we cannot comput shortest distance till all nodes.
         */

        // Check for negative cycle
        for (Edge edge : edges) {

            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;

            if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + w < dist[v]) {

                System.out.println("Negative Weight Cycle Detected");
                return new int[]{};
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int n = 5;

        List<Edge> edges = new ArrayList<>();

        /*
              0
            /   \
          6      7
         /        \
        1 ----5--> 2
        | \         |
       8|  \-4      |-3
        |           |
        v           v
        3 <----9----4

         */

        // Add edges
        edges.add(new Edge(0, 1, 6));
        edges.add(new Edge(0, 2, 7));

        edges.add(new Edge(1, 2, 5));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, -4));

        edges.add(new Edge(2, 3, -3));
        edges.add(new Edge(2, 4, 9));

        edges.add(new Edge(3, 1, -2));

        edges.add(new Edge(4, 0, 2));
        edges.add(new Edge(4, 3, 7));

        int source = 0;

        int[] distances = bellmanFord(n, edges, source);

        System.out.println("Shortest distances from source " + source);

        for (int i = 0; i < distances.length; i++) {
            System.out.println("To vertex " + i + " = " + distances[i]);
        }
    }
}
