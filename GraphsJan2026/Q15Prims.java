package src.GraphsJan2026;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q15Prims {

    // Class to store node and weight
    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        // Sort by minimum weight
        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    // Prim's Algorithm
    public static int prims(int n, List<List<Node>> graph) {

        boolean[] visited = new boolean[n];

        // min heap
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Start from node 0
        pq.add(new Node(0, 0));

        int mstWeight = 0;

        while (!pq.isEmpty()) {
            // poll out the min value
            Node current = pq.poll();

            int u = current.vertex;
            int weight = current.weight;

            // Skip if already visited
            if (visited[u]) {
                continue;
            }

            // Include node in MST
            visited[u] = true;

            // Add edge weight
            mstWeight += weight;

            // Check neighbors
            for (Node neighbor : graph.get(u)) {

                int v = neighbor.vertex;
                int edgeWeight = neighbor.weight;

                // Add only unvisited neighbors to the priority, so that next time we can grep the minimum value from this pool of edge weights
                if (!visited[v]) {
                    pq.add(new Node(v, edgeWeight));
                }
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {

        int n = 5; // Number of vertices

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        /*
              0
             / \
           2/   \6
           /     \
          1---8---3
         / \
       3/   \5
       /     \
      2---7---4
        */

        // Undirected graph
//        graph.get(0).add(new Node(1, 2));
//        graph.get(1).add(new Node(0, 2));
//
//        graph.get(0).add(new Node(3, 6));
//        graph.get(3).add(new Node(0, 6));
//
//        graph.get(1).add(new Node(2, 3));
//        graph.get(2).add(new Node(1, 3));
//
//        graph.get(1).add(new Node(3, 8));
//        graph.get(3).add(new Node(1, 8));
//
//        graph.get(1).add(new Node(4, 5));
//        graph.get(4).add(new Node(1, 5));
//
//        graph.get(2).add(new Node(4, 7));
//        graph.get(4).add(new Node(2, 7));

        graph.get(0).add(new Node(1, 5));
        graph.get(0).add(new Node(3, 15));

        graph.get(1).add(new Node(2, 10));
        graph.get(0).add(new Node(3, 20));

        graph.get(2).add(new Node(3, 25));



        int answer = prims(n, graph);

        System.out.println("Minimum Spanning Tree Weight = " + answer);
    }
}
