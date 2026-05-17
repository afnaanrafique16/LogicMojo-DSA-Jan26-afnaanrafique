package DPLec26;


/*
Given an array find the minimum sub that we can get by partitioning the array into parts

I/P: {1, 2, 7}
O/P: 4
{1, 2}, {7}
 */

import java.util.ArrayList;

public class Q9MinimumSubsetSumDifference {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7};

        int ansMinSubSetSumDiff = minSubsetSumDiff(arr);
        System.out.println(ansMinSubSetSumDiff);
    }

    public static int minSubsetSumDiff(int[] arr) {
        int range = 0;
        for (int n: arr) {
            range+=n;
        }

        //Now, the s1 + s2 = range
        //s1, s2 lies from (0, range)
        //s1 we are taking it will be before first half
        //s1 + s2 = range
        /*
        we need to minimize |s2 - s1|
        s1 + s2 = range
        s2 = range - s1
        Minimize = |range - 2s1|
         */

        // we need to find the valid s1 values, we will get those values from last row of subset sum problem



        //subset sum tabulation
        boolean[][] dp = new boolean[arr.length+1][range+1];


        //Initilisation
        for (int i=0; i<arr.length+1; i++) {
            for (int j=0; j<range+1; j++) {
                if (i==0) {
                    dp[i][j] = false;
                }

                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }


        for (int i=1; i<arr.length+1; i++) {
            for (int j=1; j<range+1; j++) {
                if (arr[i-1] <= j) {
                    //incl
                    boolean incl = dp[i-1][j-arr[i-1]];

                    //excl
                    boolean excl = dp[i-1][j];

                    boolean ans = incl || excl;
                    dp[i][j] = ans;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        // in the last row get all the values add all the values in arraylist which are true
        for (int i= arr.length; i<arr.length+1; i++) {
            for (int j=0; j<=range/2; j++) {
                if (dp[i][j] == true) {
                    arrayList.add(j);
                }
            }
        }

        //minimize range - 2s1
        int min = Integer.MAX_VALUE;
        for (int i=0; i<arrayList.size(); i++) {
            min = Math.min(min, range-2*arrayList.get(i));
        }

        return min;
    }
}
