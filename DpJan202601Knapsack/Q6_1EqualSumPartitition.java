package src.DPLec26;

/*
Given an array find if you can divide the array into two parts with equal sum
 */
public class Q6_1EqualSumPartitition {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};

        boolean ansEqualSumPart = equalSumPartition(arr, arr.length);
        System.out.println(ansEqualSumPart);
    }

    public static boolean equalSumPartition(int[] arr, int n) {
        // calculating the sum of array
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum+=arr[i];
        }

        // if sum is odd => return false
        if (sum % 2 != 0) {
            return false;
        } else {
            // find whether there exists a subset whose sum is sum/2
            return subsetSumTabulation(arr, sum/2);
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
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[wt.length][W];
    }

}
