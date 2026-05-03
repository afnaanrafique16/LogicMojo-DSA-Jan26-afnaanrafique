package src.GraphsJan2026;

public class Q5NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1,1,0,0},
                {1,1,1,0},
                {0,1,1,0},
                {0,0,0,1}
        };

//        int[][] isConnected = {
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}
//        };

        int ansNumberOfProvinces = numberOfProvincesFun(isConnected);
        System.out.println(ansNumberOfProvinces);
    }

    public static int numberOfProvincesFun(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;

        int[] visited = new int[n];

        for (int i=0; i<n; i++) {
            if (visited[i] == 0) {
                dfs(i, isConnected, visited);
                count++;
            }
        }

        return count;
    }

    /*
    Normal DFS function
     */
    public static void dfs(int currentNode, int[][] isConnected, int[] visited) {
        visited[currentNode] = 1;

        for (int i=0; i<isConnected.length; i++) {
            /*
            if there is an edge between current node and the node we are standing at
            and
            the node we are standing has not been visited yet.
             */
            if (isConnected[currentNode][i] == 1 && visited[i] == 0) {
                dfs(i, isConnected, visited);
            }
        }
    }

}
