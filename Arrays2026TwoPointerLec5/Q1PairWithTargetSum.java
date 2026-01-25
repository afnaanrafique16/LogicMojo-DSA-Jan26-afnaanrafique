package src.Arrays2026TwoPointerLec5;

import java.util.Arrays;

public class Q1PairWithTargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int target = 6;

        int[] ansPairBruteForce = pairBruteForce(arr, target);
        System.out.println(Arrays.toString(ansPairBruteForce));

        int[] ansPairOptimised = pairOptimised(arr, target);
        System.out.println(Arrays.toString(ansPairOptimised));
    }

    public static int[] pairBruteForce(int[] arr, int target) {
        // find all the sum of pairs
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public static int[] pairOptimised(int[] arr, int target) {
        // Two pointer
        int i=0, j=arr.length-1;

        while (i < j) {
            if (arr[i] + arr[j] == target) {
                return new int[]{i, j};
            } else if (arr[i] + arr[j] > target) {
                // decrement the higher value, in a hope that the sum decreases, and it might be
                // equal to target
                j--;
            } else {
                // increment the lower value, in a hope that the sum increases, and it might be
                // equal to target
                i++;
            }
        }

        return new int[]{};
    }
}
