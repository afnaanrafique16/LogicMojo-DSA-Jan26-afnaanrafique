package DPLec26;

public class Q11CoinChangeMaxNumberOfWays {
    public static void main(String[] args) {
        int[] coin = {1, 2, 3};
        int sum = 5;

        int ansTabulation = tabulationMaxNumberOfWays(coin, sum);
        System.out.println(ansTabulation);
    }

    public static int tabulationMaxNumberOfWays(int[] arr, int sum) {
        //initialization same as subset sum problem, for false = 0, true = 1

        int[][] dp = new int[arr.length+1][sum+1];


        //Initilisation
        for (int i=0; i<arr.length+1; i++) {
            for (int j=0; j<sum+1; j++) {
                if (i==0) {
                    dp[i][j] = 0;
                }

                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }


        for (int i=1; i<arr.length+1; i++) {
            for (int j=1; j<sum+1; j++) {
                if (arr[i-1] <= j) {
                    //incl
                    //just change i-1 to i
                    int incl = dp[i][j-arr[i-1]];

                    //excl
                    //int excl = recursiveKnapSack(wt, profit, capacity, n-1);
                    int excl = dp[i-1][j];

                    int ans = incl + excl;
                    dp[i][j] = ans;
                    //return ans;
                } else {
//            dp[n][capacity] = recursiveKnapSack(wt, profit, capacity, n-1);
                    dp[i][j] = dp[i-1][j];
                    //return recursiveKnapSack(wt, profit, capacity, n-1);
                }
            }
        }

        return dp[arr.length][sum];
    }
}
