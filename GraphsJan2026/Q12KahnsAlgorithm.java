package src.GraphsJan2026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q12KahnsAlgorithm {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        int nodes = 6;

        for (int i=0; i<nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // 5->0
        adjacencyList.get(5).add(0);
        // 5->2
        adjacencyList.get(5).add(2);
        // 4->0
        adjacencyList.get(4).add(0);
        // 4->1
        adjacencyList.get(4).add(1);
        // 2->3
        adjacencyList.get(2).add(3);
        // 3->1
        adjacencyList.get(3).add(1);

        ArrayList<Integer> ansTopologicalSort = topologicalSort(adjacencyList, nodes);
        System.out.println(ansTopologicalSort);
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adjacencyList, int nodes) {
        // indegree array having indegrees of all the nodes.
        int[] indegree= new int[nodes];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // calculate indegree
        for (int i=0; i<nodes; i++) {
            for (int j=0; j<adjacencyList.get(i).size(); j++) {
                int neighbor = adjacencyList.get(i).get(j);
                indegree[neighbor]++;
            }
        }

        // add the nodes having indegree as 0 to the queue
        for (int i=0; i<nodes; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int removedElement = queue.poll();

            // ans is adding the nodes with indegree 0
            ans.add(removedElement);

            // decrement the indegree of all nodes to which this polled element is attached to
            for (int i=0; i<adjacencyList.get(removedElement).size(); i++) {
                int neighbor = adjacencyList.get(removedElement).get(i);
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }

        }

        return ans;
    }
}
