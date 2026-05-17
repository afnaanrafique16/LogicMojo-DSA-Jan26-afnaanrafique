package DPLec27;

import java.util.Arrays;

public class Q12CoinChangeMinimumNumberOfCoins {
    public static void main(String[] args) {
        int[] coin = {1, 2, 3};
        int sum = 4;

//        int[] coin = {100, 100};
//        int sum = 5;

        int ansRecursive = minimumNumberOfCoinsRecursive(coin, sum, coin.length);
        System.out.println(ansRecursive >= Integer.MAX_VALUE-1 ? -1 : ansRecursive);

        int[][] dp = new int[coin.length + 1][sum + 1];
        for (final int[] line : dp) {
            Arrays.fill(line, -1);
        }

        int ansMemoization = minimumNumberOfCoinsMemoization(coin, sum, coin.length, dp);
        System.out.println(ansMemoization >= Integer.MAX_VALUE-1 ? -1 : ansMemoization);

        int ansMinimumNumberOfCoinsTabulation = minimumNumberOfCoinsTabulation(coin, sum);
        System.out.println(ansMinimumNumberOfCoinsTabulation);
    }
    public static int minimumNumberOfCoinsRecursive(int[] wt, int W, int n) {
        if (n == 0 && W == 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (W == 0) {
            return 0;
        }

        if (n == 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (wt[n-1] <= W) {
            // we are adding 1, because no matter which denomination coin we pick we are potentially picking up just one coin.
            /*
            1 denotes the number of coins (NOT THE ACTUAL DENOMINATION).
             */
            int incl = 1 + minimumNumberOfCoinsRecursive(wt, W - wt[n-1], n);

            int excl = minimumNumberOfCoinsRecursive(wt, W, n-1);

            int ans = Math.min(incl, excl);
            return ans;
        } else {
            int excl = minimumNumberOfCoinsRecursive(wt, W, n-1);
            return excl;
        }
    }


    public static int minimumNumberOfCoinsMemoization(int[] wt, int W, int n, int[][] dp) {
        if (n == 0 && W == 0) {
            return Integer.MAX_VALUE-1;
        }

        if (W == 0) {
            return 0;
        }

        if (n == 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n-1] <= W) {
            int incl = 1 + minimumNumberOfCoinsMemoization(wt, W - wt[n-1], n, dp);

            int excl = minimumNumberOfCoinsMemoization(wt, W, n-1, dp);

            int ans = Math.min(incl, excl);
            dp[n][W] = ans;
            return ans;
        } else {
            int excl = minimumNumberOfCoinsMemoization(wt, W, n-1, dp);
            dp[n][W] = excl;
            return excl;
        }
    }

    public static int minimumNumberOfCoinsTabulation(int[] wt, int W) {
        int n = wt.length;

        int INF = Integer.MAX_VALUE - 1;

        int[][] dp = new int[n + 1][W + 1];

        // Initialization
        // 0 wt needed to make sum 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // Impossible to make positive sum with 0 wt
        for (int j = 1; j <= W; j++) {
            dp[0][j] = INF;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    int incl =
                            1 + dp[i][j - wt[i - 1]];

                    int excl =
                            dp[i - 1][j];

                    dp[i][j] = Math.min(incl, excl);
                } else {
                    int excl = dp[i-1][j];
                    dp[i][j] = excl;
                }
            }
        }

        // If impossible to form sum
        if (dp[n][W] >= INF) {
            return -1;
        }

        return dp[n][W];
    }
}
