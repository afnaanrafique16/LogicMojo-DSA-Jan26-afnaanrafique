package src.GraphsJan2026;

import java.util.ArrayList;

public class Q9DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        int nodes = 4;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i=0; i<nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }


        // 0-1
        adjacencyList.get(0).add(1);
        adjacencyList.get(1).add(0);

        // 1-2
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        // 2-3
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(2);

        // 3-0
        adjacencyList.get(3).add(0);
        adjacencyList.get(0).add(3);

        boolean ansIsCyclePresent = isCyclePresent(adjacencyList, nodes);
        System.out.println(ansIsCyclePresent);
    }

    public static boolean isCyclePresent(ArrayList<ArrayList<Integer>> adjacencyList, int nodes) {
        boolean vis[] = new boolean[nodes];

        for (int i=0; i<nodes; i++) {
            if (vis[i] == false) {
                if (dfs(i, -1, vis, adjacencyList)) {
                    // If DFS finds a cycle, return true
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(int currentNode, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList) {
        visited[currentNode] = true; // Mark the current currentNode as visited

        for (int i=0; i<adjacencyList.get(currentNode).size(); i++) {
            int neighbor = adjacencyList.get(currentNode).get(i);

            /*
            if vis[n]==true && neighbor!=parent
                return true;
             */
            if (visited[neighbor] == false) {
                // check for corresponding neighbors and for them the currentNode will be the parent
                if (dfs(neighbor, currentNode, visited, adjacencyList)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If the neighbor is visited and is not the parent, a cycle is detected
                return true;
            }
        }

        return false;
    }
}
