package DPLec27;

import java.util.Arrays;

public class Q11CoinChangeTotalNumberOfWays {
    public static void main(String[] args) {
//        int[] coin = {1, 2, 3};
//        int sum = 4;
        int[] coin = {2, 5, 3, 6};
        int sum = 10;

        int ansRecursive = coinChangeTotalNumberOfWaysRecursive(coin, sum, coin.length);
        System.out.println(ansRecursive);

        int[][] dp = new int[coin.length + 1][sum + 1];
        for (final int[] line : dp) {
            Arrays.fill(line, -1);
        }

        int ansMemoization = coinChangeTotalNumberOfWaysMemoization(coin, sum, coin.length, dp);
        System.out.println(ansMemoization);

        int ansTabulation = coinChangeTotalNumberOfWaysTabulation(coin, sum, coin.length);
        System.out.println(ansTabulation);
    }

    public static int coinChangeTotalNumberOfWaysMemoization(int[] wt, int W, int n, int[][] dp) {
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
            int incl = coinChangeTotalNumberOfWaysMemoization(wt, W-wt[n-1], n, dp);

            int excl = coinChangeTotalNumberOfWaysMemoization(wt, W, n-1, dp);

            int ans = incl + excl;
            dp[n][W] = ans;
            return ans;
        } else {
            int excl = coinChangeTotalNumberOfWaysMemoization(wt, W, n-1, dp);
            dp[n][W] = excl;
            return excl;
        }
    }

    public static int coinChangeTotalNumberOfWaysRecursive(int[] wt, int W, int n) {
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
            int incl = coinChangeTotalNumberOfWaysRecursive(wt, W-wt[n-1], n);

            int excl = coinChangeTotalNumberOfWaysRecursive(wt, W, n-1);

            int ans = incl + excl;
            return ans;
        } else {
            int excl = coinChangeTotalNumberOfWaysRecursive(wt, W, n-1);
            return excl;
        }
    }

    public static int coinChangeTotalNumberOfWaysTabulation(int[] wt, int W, int n) {
        //initialization same as subset W problem, for false = 0, true = 1
        int[][] dp = new int[n+1][W+1];

        /*
        1 0 0
        1
        1
         */


        //Initialization
        for (int j=0; j<=W; j++) {
            dp[0][j] = 0;
        }

        for (int i=0; i<=n; i++) {
            dp[i][0] = 1;
        }


        /*
        change n -> i
               W -> j
         */

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=W; j++) {
                if (wt[i-1] <= j) {
                    //incl
                    int incl = dp[i][j-wt[i-1]];

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

        return dp[n][W];
    }
}
