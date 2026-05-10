package src.DPJan2026FibonacciPattern;

import java.util.Arrays;

public class Q4MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};

        int ans = minCostClimbingStairsRecursive(cost);
        System.out.println(ans);

        int ansClimbingStairsMemoization = minCostClimbingStairsMemoization(cost);
        System.out.println(ansClimbingStairsMemoization);

        int ansClimbingStairsTabulation = climbingStairsTabulation(cost);
        System.out.println(ansClimbingStairsTabulation);
    }

    public static int minCostClimbingStairsRecursive(int[] arr) {
        int ansStartFromFirst = minCostRecursive(arr, 0);
        int ansStartFromSecond = minCostRecursive(arr, 1);

        int ans = Math.min(ansStartFromFirst, ansStartFromSecond);

        return ans;
    }

    public static int minCostRecursive(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }

        int l = arr[index] + minCostRecursive(arr, index+1);
        int r = arr[index] + minCostRecursive(arr, index+2);
        int ans = Math.min(l, r);

        return ans;
    }

    public static int minCostClimbingStairsMemoization(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        int ansStartFromZerothIndex = minCostMemoization(arr, 0, dp);
        int ansStartFromFirstIndex = minCostMemoization(arr, 1, dp);

        int ans = Math.min(ansStartFromZerothIndex, ansStartFromFirstIndex);

        return ans;
    }

    public static int minCostMemoization(int[] arr, int index, int[] dp) {
        if (index >= arr.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int l = arr[index] + minCostMemoization(arr, index+1, dp);
        int r = arr[index] + minCostMemoization(arr, index+2, dp);
        int ans = Math.min(l, r);

        dp[index] = ans;

        return ans;
    }

    public static int climbingStairsTabulation(int[] arr) {
        int[] dp = new int[arr.length+1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i=2; i<=arr.length; i++) {
            int l = dp[i-1] + arr[i-1];
            int r = dp[i-2] + arr[i-2];
            int ans = Math.min(l, r);
            dp[i] = ans;
        }

        return dp[dp.length-1];
    }
}
