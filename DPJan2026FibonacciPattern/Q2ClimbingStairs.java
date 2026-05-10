package src.DPJan2026FibonacciPattern;

import java.util.Arrays;

public class Q2ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        //int n = 1;

        int ansClimbingStairsRecursion = climbingStairsRecursion(n);
        System.out.println(ansClimbingStairsRecursion);

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ansClimbingStairsMemoization = climbingStairsMemoization(n, dp);
        System.out.println(ansClimbingStairsMemoization);

        int ansClimbingStairsTabulation = climbingStairsTabulation(n);
        System.out.println(ansClimbingStairsTabulation);
    }

    public static int climbingStairsRecursion(int n) {
        /*
        if(n == 0 || n == 1) {
            return 1;
        }
         */

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int l = climbingStairsRecursion(n-1);
        int r = climbingStairsRecursion(n-2);
        int ans = l +r;

        return ans;
    }

    public static int climbingStairsMemoization(int n, int[] dp) {
        /*
        if(n == 0 || n == 1) {
            return 1;
        }
         */

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int l = climbingStairsMemoization(n-1, dp);
        int r = climbingStairsMemoization(n-2, dp);
        int ans = l + r;
        dp[n] = ans;

        return ans;
    }

    public static int climbingStairsTabulation(int n) {
        /*
        if(n == 0 || n == 1) {
            return 1;
        }
         */

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int[] dp = new int[n+1];
        // initialize dp array on the basis of base case
        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<=n; i++) {
            int l = dp[i-1];
            int r = dp[i-2];
            int ans = l+r;
            dp[i] = ans;
        }

        return dp[n];
    }
}
