package src.DPJan2026FibonacciPattern;

import java.util.Arrays;

public class Q1FibonacciNumber {
    public static void main(String[] args) {
        int n = 5;

        int ansNFibRecursion = nFibRecursion(n);
        System.out.println(ansNFibRecursion);

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int ansNfibMemoization = nFibMemoization(n, dp);
        System.out.println(ansNfibMemoization);

        int ansNFibTabulation = nFibTabulation(n);
        System.out.println(ansNFibTabulation);
    }

    public static int nFibRecursion(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return n;
        }

        int l = nFibRecursion(n-1);
        int r = nFibRecursion(n-2);
        int ans = l+r;

        return ans;
    }

    public static int nFibMemoization(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int l = nFibMemoization(n-1, dp);
        int r = nFibMemoization(n-2, dp);
        int ans = l+r;
        dp[n] = ans;

        return ans;
    }

    public static int nFibTabulation(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        // fill the vacant places of the dp array
        for (int i=2; i<=n; i++) {
            int l = dp[i-1];
            int r = dp[i-2];
            int ans = l+r;
            dp[i] = ans;
        }

        // return the last value of dp array.
        return dp[n];
    }
}
