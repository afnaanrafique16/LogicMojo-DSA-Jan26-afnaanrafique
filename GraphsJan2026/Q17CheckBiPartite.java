package src.GraphsJan2026;

import java.util.ArrayList;
import java.util.Arrays;

public class Q17CheckBiPartite {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        int nodes = 8;

        for (int i=0; i<nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        addEdge(adjacencyList, 0, 1);
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 4);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 3, 5);
        addEdge(adjacencyList,  4, 5);
        addEdge(adjacencyList,  3, 6);
        addEdge(adjacencyList,  6, 7);

//        addEdge(adjacencyList, 0, 1);
//        addEdge(adjacencyList, 1, 2);
//        addEdge(adjacencyList, 2, 3);

        boolean ansIsBiPartite = isBiPartite(adjacencyList, nodes);
        System.out.println(ansIsBiPartite);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public static boolean isBiPartite(ArrayList<ArrayList<Integer>> adjacencyList, int nodes) {
        // 0 -> black
        // 1 -> white
        int[] visited = new int[nodes];
        Arrays.fill(visited, -1);

        for (int i=0; i<nodes; i++) {
            if (visited[i] == -1) {
                boolean ans = dfs(adjacencyList, visited, i, 0);
                if (ans == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adjacencyList, int[] visited, int node, int color) {
        visited[node] = color;

        for (int i=0; i<adjacencyList.get(node).size(); i++) {
            int neighbor = adjacencyList.get(node).get(i);

            if (visited[neighbor] == -1) {
                boolean ans = dfs(adjacencyList, visited, neighbor, 1-color);
                if (ans == false) {
                    return ans;
                }
            } else if (visited[neighbor] == color) {
                return false;
            }
        }

        return true;
    }
}
