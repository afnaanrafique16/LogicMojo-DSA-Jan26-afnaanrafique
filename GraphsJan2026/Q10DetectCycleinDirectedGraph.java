package src.GraphsJan2026;

import java.util.ArrayList;

public class Q10DetectCycleinDirectedGraph {
    public static void main(String[] args) {
        int nodes = 4;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i=0; i<nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

//        // 0-1
//        adjacencyList.get(0).add(1);
//
//        // 1-2
//        adjacencyList.get(1).add(2);
//
//        // 2-3
//        adjacencyList.get(2).add(3);
//
//        // 3-0
//        adjacencyList.get(3).add(0);

        // 0->1
        adjacencyList.get(0).add(1);

        // 0->3
        adjacencyList.get(0).add(3);

        // 1->2
        adjacencyList.get(1).add(2);

        // 3->2
        adjacencyList.get(3).add(2);

        boolean ansIsCyclePresent = isCyclePresent(adjacencyList, nodes);
        System.out.println(ansIsCyclePresent);
    }

    public static boolean isCyclePresent(ArrayList<ArrayList<Integer>> adjacencyList, int nodes) {
        // to denote nodes visited.
        int[] visited = new int[nodes];

        // to denote node getting visited is in the path.
        int[] inPath = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            if (visited[i] == 0) {
                boolean ans = dfs(i, adjacencyList, visited, inPath);
                if (ans) {
                    return true;
                }
            }
        }
        return false; // No cycle detected

    }

    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adjacencyList, int[] visited, int[] inPath){
        visited[node] = 1;
        inPath[node] = 1;

        for (int i=0; i<adjacencyList.get(node).size(); i++) {
            int neighbor = adjacencyList.get(node).get(i);

            if (visited[neighbor] == 0) {
                boolean ans = dfs(neighbor, adjacencyList, visited, inPath);
                if (ans) {
                    return true;
                }
            }
            // If the neighbor is in the recursion stack, it means a cycle is detected
            // if this is true this implies already visited and in the same path
            else if (visited[neighbor] == 1 && inPath[neighbor] == 1) {
                return true;
            }
        }

        // As the node is no longer in the given path so mark it as 0. (Toggling back)
        inPath[node] = 0;
        return false;
    }

}
