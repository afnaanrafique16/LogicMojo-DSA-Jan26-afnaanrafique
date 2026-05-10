package src.GraphsJan2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q14Djikstra {
    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight; // Sort by weight
        }
    }
    public static int[] dijkstra(int n, List<List<Node>> graph, int source) {
        int[] dist = new int[n]; // Distance array
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances to infinity
        dist[source] = 0; // Distance to source is 0

        // min heap to grep the minimum weight for every node.
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0)); // Start with source

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            // Process all neighbors of current vertex
            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // Relaxation step
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v])); // Add updated distance to priority queue
                }
            }
        }

        return dist; // Shortest distances
    }

    public static void main(String[] args) {
        int n = 5; // Number of vertices
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges: graph.get(src).add(new Node(dest, weight));
//        graph.get(0).add(new Node(1, 2));
//        graph.get(0).add(new Node(3, 6));
//        graph.get(1).add(new Node(2, 3));
//        graph.get(1).add(new Node(3, 8));
//        graph.get(1).add(new Node(4, 5));
//        graph.get(2).add(new Node(4, 7));
//        graph.get(3).add(new Node(4, 9));

        graph.get(0).add(new Node(1, 2));
        graph.get(0).add(new Node(3, 6));
        graph.get(0).add(new Node(4, 7));

        graph.get(1).add(new Node(2, 5));
        graph.get(1).add(new Node(3, 8));

        graph.get(3).add(new Node(4, 9));


        int source = 0;
        int[] distances = dijkstra(n, graph, source);

        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To vertex " + i + " = " + distances[i]);
        }
    }
}
