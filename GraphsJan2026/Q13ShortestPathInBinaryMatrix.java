package src.GraphsJan2026;

import java.util.LinkedList;
import java.util.Queue;

public class Q13ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 0, 0},
//                {0, 0, 0},
//                {0, 0, 0}
//        };

        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        int ansShortestPathInBinaryMatrix = shortestPathInBinaryMatrix(grid);
        System.out.println(ansShortestPathInBinaryMatrix);
    }

    public static int shortestPathInBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // If start or end is blocked → no path
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // [row,col,distance] => (0, 0, 1) => standing at 0,0 with number of nodes as 1
        Queue<int[]> queue = new LinkedList<>();

        // Visited array
        boolean[][] visited = new boolean[n][n];

        // Start from (0,0) with distance 1
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        // 8 directions
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1,  0,  1, -1, 1, -1, 0, 1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];
            int dist = cell[2];

            // If destination reached → return distance
            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            // Explore all 8 directions
            for (int k = 0; k < 8; k++) {
                int newRow = row + dx[k];
                int newCol = col + dy[k];

                // Check valid cell
                if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 0 &&
                        !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol, dist + 1});
                }
            }
        }

        // No path found
        return -1;
    }
}
