package src.DPJan2026FibonacciPattern;

import java.util.Arrays;

public class Q5JumpGame1 {

    public static void main(String[] args) {

        int[] arr = {2,3,1,1,4};

        boolean ansJumpGameRecursion =
                jumpGameRecursion(arr);

        System.out.println(ansJumpGameRecursion);

        Boolean[] dp = new Boolean[arr.length];

        boolean ansJumpGameMemoization =
                jumpGameMemoization(arr, 0, dp);

        System.out.println(ansJumpGameMemoization);

        boolean ansJumpGameTabulation =
                jumpGameTabulationFromStart(arr);

        System.out.println(ansJumpGameTabulation);
    }

    // RECURSION
    public static boolean jumpGameRecursion(int[] arr) {
        return helperRecursion(arr, 0);
    }

    public static boolean helperRecursion(
            int[] arr,
            int currentIndex) {

        // reached end
        if (currentIndex >= arr.length - 1) {
            return true;
        }

        // cannot move further
        if (arr[currentIndex] == 0) {
            return false;
        }

        // try all possible jumps
        for (int step = 1;
             step <= arr[currentIndex];
             step++) {

            boolean possible =
                    helperRecursion(
                            arr,
                            currentIndex + step
                    );

            // if any path works
            if (possible) {
                return true;
            }
        }

        return false;
    }

    // MEMOIZATION
    public static boolean jumpGameMemoization(
            int[] arr,
            int currentIndex,
            Boolean[] dp) {

        // reached end
        if (currentIndex >= arr.length - 1) {
            return true;
        }

        // already solved
        if (dp[currentIndex] != null) {
            return dp[currentIndex];
        }

        // cannot move further
        if (arr[currentIndex] == 0) {
            dp[currentIndex] = false;
            return false;
        }

        // try all jumps
        for (int step = 1;
             step <= arr[currentIndex];
             step++) {

            boolean possible =
                    jumpGameMemoization(
                            arr,
                            currentIndex + step,
                            dp
                    );

            if (possible) {
                dp[currentIndex] = true;
                return true;
            }
        }

        dp[currentIndex] = false;

        return false;
    }

    // TABULATION
    public static boolean jumpGameTabulationFromStart(int[] arr) {

        int n = arr.length;

        boolean[] dp = new boolean[n];

        // starting index is always reachable
        dp[0] = true;

        for (int i = 0; i < n; i++) {

            // if I cannot reach this index, skip it
            if (!dp[i]) {
                continue;
            }

            // from index i, try all jumps
            for (int step = 1; step <= arr[i]; step++) {

                int nextIndex = i + step;

                if (nextIndex < n) {
                    dp[nextIndex] = true;
                }
            }
        }

        return dp[n - 1];
    }
}
