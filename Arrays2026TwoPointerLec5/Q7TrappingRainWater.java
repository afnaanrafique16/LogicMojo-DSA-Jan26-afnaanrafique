package src.Arrays2026TwoPointerLec5;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

 */

public class Q7TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 3, 2, 5};

        int ansTrappingRainWaterWithSpace = trappingRainWaterWithSpace(arr);
        System.out.println(ansTrappingRainWaterWithSpace);

        int ansTrappingRainWaterWithoutSpace = trappingRainWaterWithoutSpace(arr);
        System.out.println(ansTrappingRainWaterWithoutSpace);
    }

    public static int trappingRainWaterWithSpace(int[] arr) {
        int[] leftMax = new int[arr.length];
        int[] rMax = new int[arr.length];
        int ans=0;

        leftMax[0] = arr[0];
        rMax[arr.length-1] = arr[arr.length-1];

        for (int i=1; i<arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        for (int i=arr.length-2; i>=0; i--) {
            rMax[i] = Math.max(rMax[i+1], arr[i]);
        }

        for (int i=0; i<arr.length; i++) {
            ans += Math.min(leftMax[i], rMax[i]) - arr[i];
        }

        return ans;
    }

    public static int trappingRainWaterWithoutSpace(int[] arr) {
        int l=0;
        int r=arr.length-1;
        int lMax = 0;
        int rMax = 0;
        int ansTrappedWater = 0;

        while (l < r) {
            if (arr[l] < arr[r]) {
                //start filling from lhs
                lMax = Math.max(lMax, arr[l]);
                ansTrappedWater += (lMax - arr[l]);
                l++;
            } else {
                // start filling from RHS
                rMax = Math.max(rMax, arr[r]);
                ansTrappedWater += (rMax - arr[r]);
                r--;
            }
        }

        return ansTrappedWater;
    }

}
