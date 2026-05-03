package src.GraphsJan2026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q3BFSAlgorithm {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        int n = 8;

        for (int i=0; i<n; i++) {
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

        bfs(lists, 0, n);
    }

    public static void addEdge(List<List<Integer>> lists, int i, int j) {
        lists.get(i).add(j);
        lists.get(j).add(i);
    }

    public static void bfs(List<List<Integer>> lists, int source, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        int[] visited = new int[n];
        visited[source] = 1;

        while (!queue.isEmpty()) {
            /*
            poll
            output
            explore neighbors
             */

            int removedNode = queue.poll();
            System.out.print(removedNode + " ");

            for (int i=0; i<lists.get(removedNode).size(); i++) {
                int neighborElement = lists.get(removedNode).get(i);

                /*
                if unvisited
                add it into the queue
                mark it as visited
                 */
                if (visited[neighborElement] == 0) {
                    queue.add(neighborElement);
                    visited[neighborElement] = 1;
                }
            }
        }
    }
}
