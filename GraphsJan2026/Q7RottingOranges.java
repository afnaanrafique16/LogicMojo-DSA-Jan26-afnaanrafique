package src.GraphsJan2026;

import java.util.LinkedList;
import java.util.Queue;

public class Q7RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

//        int[][] grid = {
//                {2, 1, 1},
//                {1, 1, 0},
//                {0, 2, 1}
//        };


        int ansRottingOranges = rottingOrangesFun(grid);
        System.out.println(ansRottingOranges);
    }

    public static int rottingOrangesFun(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOrangesCount = 0;

        // Step 1: Add all rotten oranges to queue
        // and count freshOrangesCount oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOrangesCount++;
                }
            }
        }

        int time = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty() && freshOrangesCount > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                int row = cell[0];
                int col = cell[1];

                for (int k = 0; k < 4; k++) {
                    int newRow = row + dx[k];
                    int newCol = col + dy[k];

                    // newRow and newCol are within bounds && fresh orange
                    if (newRow >= 0 && newRow < rows &&
                            newCol >= 0 && newCol < cols &&
                            grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        // the moment orange becomes rotten add it in the queue
                        queue.add(new int[]{newRow, newCol});
                        freshOrangesCount--;
                    }
                }
            }

            time++;
        }

        return freshOrangesCount == 0 ? time : -1;
    }
}
