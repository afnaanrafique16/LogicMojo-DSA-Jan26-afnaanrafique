package DPLec26;

import java.util.Arrays;

/*
Given an array, count the number of subsets present with a given sum.

int[] arr = {2, 3, 5, 6, 8, 10};
{2, 3, 5}, {2, 8}, {10} = 3

 */
public class Q7CountOfSubsetSumWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;

        int ansCountSubsetWithGivenSumRecursive = countSubsetWithGivenSumRecursive(arr, sum, arr.length);
        System.out.println(ansCountSubsetWithGivenSumRecursive);

        int[][] dp = new int[arr.length+1][sum+1];
        for (final int[] line : dp) {
            Arrays.fill(line, -1);
        }

        int ansCountSubsetWithGivenSumMemoization = countSubsetWithGivenSumMemoization(arr, sum, arr.length, dp);
        System.out.println(ansCountSubsetWithGivenSumMemoization);

        int ansCountSubsetTabulation = countSubsetTabulation(arr, sum);
        System.out.println(ansCountSubsetTabulation);
    }

    public static int countSubsetWithGivenSumRecursive(int[] wt, int W, int n) {
        if (n == 0 && W == 0) {
            return 1;
        }

        if (W == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        if (wt[n-1] <= W) {
            int incl = countSubsetWithGivenSumRecursive(wt, W-wt[n-1], n-1);
            int excl = countSubsetWithGivenSumRecursive(wt, W, n-1);
            int ans = incl + excl;

            return ans;
        } else {
            int excl = countSubsetWithGivenSumRecursive(wt, W, n-1);
            return excl;
        }
    }

    public static int countSubsetWithGivenSumMemoization(int[] wt, int W, int n, int[][] dp) {
        if (n == 0 && W == 0) {
            return 1;
        }

        if (W == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n-1] <= W) {
            int incl = countSubsetWithGivenSumMemoization(wt, W-wt[n-1], n-1, dp);
            int excl = countSubsetWithGivenSumMemoization(wt, W, n-1, dp);
            int ans = incl + excl;
            dp[n][W] = ans;

            return ans;
        } else {
            int excl = countSubsetWithGivenSumMemoization(wt, W, n-1, dp);
            dp[n][W] = excl;
            return excl;
        }
    }


    public static int countSubsetTabulation(int[] wt, int W) {
        //initialization same as subset W problem, for false = 0, true = 1

        int[][] dp = new int[wt.length+1][W+1];


        //Initilisation
        for (int i=0; i<wt.length+1; i++) {
            for (int j=0; j<W+1; j++) {
                if (i==0) {
                    dp[i][j] = 0;
                }

                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }


        for (int i=1; i<wt.length+1; i++) {
            for (int j=1; j<W+1; j++) {
                if (wt[i-1] <= j) {
                    //incl
                    int incl = dp[i-1][j-wt[i-1]];

                    //excl
                    int excl = dp[i-1][j];

                    int ans = incl + excl;
                    dp[i][j] = ans;
                } else {
                    int excl = dp[i-1][j];
                    dp[i][j] = excl;
                }
            }
        }

        return dp[wt.length][W];
    }
}
