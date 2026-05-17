package DPLec26;

import java.util.Arrays;

public class Q4ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] profit = {10, 40, 50, 70};
        int W = 8;

        int ansRecursive = recursiveKnapSack(wt, profit, W, wt.length);
        System.out.println(ansRecursive);

        int[][] dp = new int[wt.length + 1][W + 1];
        for (final int[] line : dp) {
            Arrays.fill(line, -1);
        }
        int ansMemoization = memoizationKnapSack(wt, profit, W, wt.length, dp);
        System.out.println(ansMemoization);

        int ansTabulation = tabulation(wt, profit, W, wt.length);
        System.out.println(ansTabulation);
    }

    public static int recursiveKnapSack(int[] wt, int[] profit, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n-1] <= W) { // Wi <= Capacity
            //incl
            int incl = profit[n-1] + recursiveKnapSack(wt, profit, W - wt[n-1], n-1);

            //excl
            int excl = recursiveKnapSack(wt, profit, W, n-1);

            int ans = Math.max(incl, excl);
            return ans;
        } else { // Wi > W of knapsack
            int excl = recursiveKnapSack(wt, profit, W, n-1);
            return excl;
        }
    }

    public static int memoizationKnapSack(int[] wt, int[] profit, int W, int n, int[][] dp) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }


        if (wt[n-1] <= W) {
            //incl
            int incl = profit[n-1] + memoizationKnapSack(wt, profit, W - wt[n-1], n-1, dp);

            //excl
            int excl = memoizationKnapSack(wt, profit, W, n-1, dp);

            int ans = Math.max(incl, excl);
            dp[n][W] = ans;
            return ans;
        } else {
            int excl = memoizationKnapSack(wt, profit, W, n-1, dp);
            dp[n][W] = excl;
            return excl;
            //return recursiveKnapSack(wt, profit, W, n-1);
        }
    }

    public static int tabulation(int[] wt, int[] profit, int W, int n) {
        int[][] dp = new int[n+1][W+1];

        //Step - 1 => initialisation, same as base case of recursive implementation
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<W+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
            }
        }

        //Step - 2, Change recursive calls to iterative implementation
        //keep inside loop and change n -> i, W -> j

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=W; j++) {
                if (wt[i-1] <= j) {
                    int incl = profit[i-1] + dp[i-1][j-wt[i-1]];
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
