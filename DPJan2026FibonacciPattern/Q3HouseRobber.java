package src.DPJan2026FibonacciPattern;

import java.util.Arrays;

public class Q3HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        int ansHouseRobberRecursion = houseRobberRecursion(nums);
        System.out.println(ansHouseRobberRecursion);

        int ansHouseRobberMemoization = houseRobberMemoization(nums);
        System.out.println(ansHouseRobberMemoization);

        int ansDemoCheck = demoCheck(nums);  // fails for 2, 1, 1, 2
        System.out.println(ansDemoCheck);

        int ansHouseRobberTabulation = houseRobberTabulation(nums);
        System.out.println(ansHouseRobberTabulation);
    }

    public static int demoCheck(int[] arr) {
        int firstAlternatingSum = 0;
        int secondAlternatingSum = 0;

        for (int i=0; i<arr.length; i=i+2) {
            firstAlternatingSum+=arr[i];
        }

        for (int i=1; i<arr.length; i=i+2) {
            secondAlternatingSum+=arr[i];
        }

        return Math.max(firstAlternatingSum, secondAlternatingSum);

    }

    public static int houseRobberRecursion(int[] arr) {
        int ansHelper = helperRec(arr, 0);
        return ansHelper;
    }

    public static int helperRec(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }

        //incl
        int l = arr[index] + helperRec(arr, index+2);  // i+2 is not adjacent

        //excl
        int r = helperRec(arr, index+1);
        int ans = Math.max(l, r);

        return ans;
    }

    public static int houseRobberMemoization(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        int ansHelperMemoization = helperMemoization(arr, 0, dp);
        return ansHelperMemoization;
    }

    public static int helperMemoization(int[] arr, int index, int[] dp) {
        if (index >= arr.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        //incl
        int l = arr[index] + helperMemoization(arr, index+2, dp);

        //excl
        int r = helperMemoization(arr, index+1, dp);
        int ans = Math.max(l, r);

        dp[index] = ans;
        return ans;
    }

    public static int houseRobberTabulation(int[] arr) {
        if (arr.length == 0)
            return 0;

        if (arr.length == 1)
            return arr[0];

        int[] dp = new int[arr.length];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i=2; i<arr.length; i++) {
            int l = arr[i] + dp[i-2];
            int r = dp[i-1];
            int ans = Math.max(l, r);
            dp[i] = ans;
        }

        return dp[arr.length-1];
    }
}
