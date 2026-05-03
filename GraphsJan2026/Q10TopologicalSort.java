package src.GraphsJan2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Q10TopologicalSort {
    public static void main(String[] args) {
        int nodes = 6;

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Graph:
        // 5 → 2 → 3 → 1
        // 5 → 0
        // 4 → 0
        // 4 → 1

        adjacencyList.get(5).add(2);
        adjacencyList.get(5).add(0);
        adjacencyList.get(4).add(0);
        adjacencyList.get(4).add(1);
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(1);

        int[] ansTopologicalSort = topologicalSort(adjacencyList, nodes);
        System.out.println(Arrays.toString(ansTopologicalSort));
    }
    public static int[] topologicalSort(ArrayList<ArrayList<Integer>> adjacencyList, int nodes) {
        int[] visited = new int[nodes];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<nodes; i++) {
            if (visited[i] == 0) {
                dfs(adjacencyList, visited, i, stack);
            }
        }

        int[] ans = new int[nodes];
        int p=0;

        while (!stack.isEmpty()) {
            ans[p++] = stack.pop();
        }

        return ans;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adjacencyList, int[] visited, int currentNode, Stack<Integer> stack) {
        visited[currentNode] = 1;

        for (int i=0; i<adjacencyList.get(currentNode).size(); i++) {
            int neighbor = adjacencyList.get(currentNode).get(i);

            if (visited[neighbor] == 0) {
                dfs(adjacencyList, visited, neighbor, stack);
            }
        }

        // push the element onto the stack before going back
        stack.push(currentNode);
    }
}
