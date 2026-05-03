package src.GraphsJan2026;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q8_01Matrix {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] result = updateMatrix(mat);

        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();

        // Distance array
        int[][] dist = new int[rows][cols];

        //  Step 1: Initialize
        // add 0 cell in the queue and make 1 cell as unvisited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 0) {
                    // If it's 0 → distance is 0
                    dist[i][j] = 0;

                    // Add all 0s to queue (starting points)
                    queue.add(new int[]{i, j});

                } else {
                    // If it's 1 → mark as unvisited (making -1 because to mark it is not visited)
                    dist[i][j] = -1;
                }
            }
        }

        // Directions: up, right, down, left
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // Step 2: BFS
        while (!queue.isEmpty()) {

            // Take one cell from queue
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            // Check all 4 directions
            for (int k = 0; k < 4; k++) {

                int newRow = row + dx[k];
                int newCol = col + dy[k];

                // Step 3: Check if valid and not visited
                if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        dist[newRow][newCol] == -1) {

                    // Step 4: Assign distance
                    dist[newRow][newCol] = dist[row][col] + 1;

                    // Step 5: Add to queue for further spreading
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        return dist;
    }
}
