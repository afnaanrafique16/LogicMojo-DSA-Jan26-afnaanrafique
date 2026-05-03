package src.GraphsJan2026;

public class Q6NumberOfIslands {
    public static void main(String[] args) {
//        char[][] grid = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        };

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int ansNumberOfIslands = numberOfIslandsFun(grid);
        System.out.println(ansNumberOfIslands);
    }

    public static int numberOfIslandsFun(char[][] grid) {
        int count = 0;

        /*
        apply dfs for all land values in adj matrix
         */
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        // if the value is out of bound, unvisited -> return right away
        if (i < 0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0') {
            return;
        }

        // mark the land as water so that next time when u see this value,
        // u don't apply dfs again on it
        grid[i][j] = '0';

        // explore all the four directions in order to find neighboring lands
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
