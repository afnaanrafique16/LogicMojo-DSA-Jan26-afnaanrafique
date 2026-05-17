package DPLec27;


import java.util.Arrays;

/*
EXACTLY SAME as Unbounded knapsack
 */
public class Q10RodCuttingProblem {
    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int N = 8;

        int ansRodCuttingProblemRecursive = rodCuttingProblemRecursive(length, prices, prices.length, prices.length);
        System.out.println(ansRodCuttingProblemRecursive);

        int[][] dp = new int[length.length+1][N+1];
        for (final int[] line : dp) {
            Arrays.fill(line, -1);
        }

        int ansRodCuttingProblemMemoization = rodCuttingProblemMemoization(length, prices, N, length.length, dp);
        System.out.println(ansRodCuttingProblemMemoization);

        int ansTabulation = rodCuttingTabulation(length, prices, N, N);
        System.out.println(ansTabulation);
    }

    public static int rodCuttingProblemRecursive(int[] wt, int[] profit, int W, int n) {
        // SAME AS UNBOUNDED KNAPSACK and 01 Knapsack
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n-1] <= W) { // Wi <= Capacity
            //incl - if we include this object, what is the profit we will get
            int incl = profit[n-1] + rodCuttingProblemRecursive(wt, profit, W - wt[n-1], n);

            //excl - if we exclude this object, what is the profit we will get
            int excl = rodCuttingProblemRecursive(wt, profit, W, n-1);

            int ans = Math.max(incl, excl);
            return ans;
        } else { // Wi > W of knapsack
            int excl = rodCuttingProblemRecursive(wt, profit, W, n-1);
            return excl;
        }
    }

    public static int rodCuttingProblemMemoization(int[] wt, int[] profit, int W, int n, int[][] dp) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n-1] <= W) { // Wi <= Capacity
            //incl
            int incl = profit[n-1] + rodCuttingProblemMemoization(wt, profit, W - wt[n-1], n, dp);

            //excl
            int excl = rodCuttingProblemMemoization(wt, profit, W, n-1, dp);

            int ans = Math.max(incl, excl);

            dp[n][W] = ans;
            return ans;
        } else { // Wi > W of knapsack
            int excl = rodCuttingProblemMemoization(wt, profit, W, n-1, dp);
            dp[n][W] = excl;
            return excl;
        }
    }


    public static int rodCuttingTabulation(int[] wt, int[] profit, int W, int n) {
        int[][] dp = new int[n+1][W+1];
        //or
        //int[][] dp = new int[W+1][W+1];

        //Step - 1 => initialisation, same as base case of recursive implementation
        for (int j=0; j<=W; j++) {
            dp[0][j] = 0;
        }

        // initialize 1st columns to 0
        for (int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }

        //Step - 2, Change recursive calls to iterative implementation
        //keep inside loop and change n -> i, W -> j

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=W; j++) {
                if (wt[i-1] <= j) {
                    //incl
                    int incl = profit[i-1] + dp[i][j-wt[i-1]];

                    //excl
                    int excl = dp[i-1][j];

                    int ans = Math.max(incl, excl);
                    dp[i][j] = ans;
                } else {
                    int excl = dp[i-1][j];
                    dp[i][j] = excl;
                }
            }
        }

        return dp[n][W];
    }
}
