package src.GraphsJan2026;

import java.util.ArrayList;
import java.util.List;

public class Q2AdjacencyListRepresentation {
    static List<List<Integer>> adjList;
    static int numVertices;

    public static void initGraph(int n) {
        numVertices = n;
        adjList = new ArrayList<>();

        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public static void addEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public static void printGraph(List<List<Integer>> adjList) {
        for (int i=0; i<adjList.size(); i++) {
            System.out.print(i + ": ");
            for (int j=0; j<adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        initGraph(4);

        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(3, 0);

        printGraph(adjList);

    }
}
