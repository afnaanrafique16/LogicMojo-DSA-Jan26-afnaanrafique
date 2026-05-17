package DPLec26;

import java.util.Arrays;

public class Q5SubsetSumProblem {
    public static void main(String[] args) {
        //Return true if there exists any subset whose sume equals to Sum
        int[] arr = {1, 3, 5, 7};
        int sum = 6;
        //int sum = 14;

        boolean ansSubsetSumRecursive = subsetSumRecursive(arr, sum, arr.length);
        System.out.println(ansSubsetSumRecursive);

        // initializes to null
        Boolean[][] dp = new Boolean[arr.length+1][sum+1];

        Boolean ansSubsetSumMemoization = subsetSumMemoization(arr, sum, arr.length, dp);
        System.out.println(ansSubsetSumMemoization);

        boolean ansSubsetSum = subsetSumTabulation(arr, sum);
        System.out.println(ansSubsetSum);
    }

    public static boolean subsetSumRecursive(int[] wt, int W, int n) {
        if (n == 0 && W == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        if (W == 0) {
            return true;
        }

        if (wt[n-1] <= W) {
            //incl
            boolean incl = subsetSumRecursive(wt, W - wt[n-1], n-1);

            //excl
            boolean excl = subsetSumRecursive(wt, W, n-1);

            boolean ans = incl || excl;

            return ans;
        } else {
            boolean excl = subsetSumRecursive(wt, W, n-1);
            return excl;
        }
    }

    public static Boolean subsetSumMemoization(int[] wt, int W, int n, Boolean[][] dp) {
        if (n == 0 && W == 0) {
            return true;
        }

        // no array element and some sum
        if (n == 0) {
            return false;
        }

        // 0 sum and array elements present -> return empty subset
        if (W == 0) {
            return true;
        }

        if (dp[n][W] != null) {
            return dp[n][W];
        }

        if (wt[n-1] <= W) {
            Boolean incl = subsetSumMemoization(wt, W-wt[n-1], n-1, dp);

            Boolean excl = subsetSumMemoization(wt, W, n-1, dp);

            Boolean ans = incl || excl;
            dp[n][W] = ans;

            return ans;
        } else {
            Boolean excl = subsetSumMemoization(wt, W, n-1, dp);
            dp[n][W] = excl;
            return excl;
        }
    }

    public static boolean subsetSumTabulation(int[] wt, int W) {
        boolean[][] dp = new boolean[wt.length+1][W+1];

        //Initialization
        for (int i=0; i<wt.length+1; i++) {
            for (int j=0; j<W+1; j++) {
                if (i==0) {
                    dp[i][j] = false;
                }

                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }
        /*
        change n->i
        j->W
         */
        //Same as 01 knapsack
        for (int i=1; i<wt.length+1; i++) {
            for (int j=1; j<W+1; j++) {
                if (wt[i-1] <= j) {
                    //incl
                    boolean incl = dp[i-1][j-wt[i-1]];

                    //excl
                    boolean excl = dp[i-1][j];

                    boolean ans = incl || excl;
                    dp[i][j] = ans;
                } else {
                    boolean excl = dp[i-1][j];
                    dp[i][j] = excl;
                }
            }
        }

        return dp[wt.length][W];
    }
}
