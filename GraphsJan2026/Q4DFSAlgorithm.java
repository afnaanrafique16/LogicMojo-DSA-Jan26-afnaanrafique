package src.GraphsJan2026;

import java.util.ArrayList;
import java.util.List;

public class Q4DFSAlgorithm {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();

        int nodes = 8;
        int[] visited = new int[nodes];

        for (int i=0; i<nodes; i++) {
            lists.add(new ArrayList<>());
        }

        addEdge(lists, 0, 1);
        addEdge(lists, 0, 2);
        addEdge(lists, 1, 3);
        addEdge(lists, 1, 4);
        addEdge(lists, 2, 5);
        addEdge(lists, 2, 6);
        addEdge(lists, 3, 7);
        addEdge(lists, 4, 7);
        addEdge(lists, 5, 7);
        addEdge(lists, 6, 7);

        dfs(lists, visited, nodes, 0);
    }

    public static void addEdge(List<List<Integer>> lists, int i, int j) {
        lists.get(i).add(j);
        lists.get(j).add(i);
    }

    public static void dfs(List<List<Integer>> lists, int[] visited, int nodes, int currentNode) {
        /*
        mark the node as visited
        output it
         */
        visited[currentNode] = 1;
        System.out.print(currentNode + " ");

        /*
        for each neighbor go as deep as possible
         */
        for (int i=0; i<lists.get(currentNode).size(); i++) {
            int neighborNode = lists.get(currentNode).get(i);

            // if the neighborNode is not visited => DFS
            if (visited[neighborNode] == 0) {
                dfs(lists, visited, nodes, neighborNode);
            }
        }

    }


}
