package src.GraphsJan2026;

public class Q1AdjacencyMatrixRepresentation {
    static int[][] adjMatrix;
    static int numVertices;

    public static void initGraph(int n) {
        numVertices = n;
        // number of nodes * number of nodes
        adjMatrix = new int[n][n];
    }

    /*
    there is an edge from i->j and j->i (for undirected graph)
     */
    public static void addEdge(int i, int j) {
        // subtract from the minimum value and then mark
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public static void printGraph(int[][] adjMatrix) {
        for (int i=0; i<adjMatrix.length; i++) {
            for (int j=0; j<adjMatrix[0].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        initGraph(4);

        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2,3);
        addEdge(3,0);

        printGraph(adjMatrix);
    }
}
