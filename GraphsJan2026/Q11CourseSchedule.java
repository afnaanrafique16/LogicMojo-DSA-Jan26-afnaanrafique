package src.GraphsJan2026;

import java.util.ArrayList;

public class Q11CourseSchedule {
    public static void main(String[] args) {
        int nodes = 2;
        int[][] prerequisites = {
                {1, 0}
        };

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i=0; i<nodes; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }

        for (int i=0; i<prerequisites.length; i++) {
            adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean ansCourseSchedule = courseSchedule(adjacencyList, nodes);
        System.out.println(ansCourseSchedule);
    }

    // Cycle detection in a directed graph
    public static boolean courseSchedule(ArrayList<ArrayList<Integer>> adjacencyList, int nodes) {
        // detect cycle in a directed graph
        boolean[] visited = new boolean[nodes];
        boolean[] inPath = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                if (dfs(i, adjacencyList, visited, inPath)) {
                    return false; // Cycle detected (Because we cannot select courses for a cycle)
                }
            }
        }
        return true; // No cycle detected

    }

    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, boolean[] inPath){
        visited[node] = true;
        inPath[node] = true;

        for (int i=0; i<adjacencyList.get(node).size(); i++) {
            int neighbor = adjacencyList.get(node).get(i);

            if (!visited[neighbor]) {
                if (dfs(neighbor, adjacencyList, visited, inPath)) {
                    return true;
                }
            }
            // If the neighbor is in the recursion stack, it means a cycle is detected
            // if this is true this implies already visited and in the same path
            else if (visited[neighbor] == true && inPath[neighbor] == true) {
                return true;
            }
        }
        // Remove the node from the recursion stack before backtracking
        inPath[node] = false;
        return false;
    }
}
