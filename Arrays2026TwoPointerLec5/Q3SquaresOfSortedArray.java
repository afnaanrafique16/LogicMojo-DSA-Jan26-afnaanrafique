package src.Arrays2026TwoPointerLec5;

import java.util.Arrays;

public class Q3SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};


        int[] ansSquareOfSortedArrayBF = squareOfSortedArrayBF(nums);
        System.out.println(Arrays.toString(ansSquareOfSortedArrayBF));

        int[] ansSquareOfSortedArrayOptimised = squareOfSortedArray(nums);
        System.out.println(Arrays.toString(ansSquareOfSortedArrayOptimised));
    }

    // O(nlogn)
    public static int[] squareOfSortedArrayBF(int[] arr) {
        int[] ansArr = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            ansArr[i] = arr[i] * arr[i];
        }

        Arrays.sort(ansArr);

        return ansArr;
    }

    public static int[] squareOfSortedArray(int[] arr) {
        int i=0, j=arr.length-1;
        int[] ansArr = new int[arr.length];

        // last of second array
        int k=ansArr.length-1;

        while (i <= j) {
            int x = Math.abs(arr[i]);
            int y = Math.abs(arr[j]);

            if (x > y) {
                ansArr[k--] = x*x;
                i++;
            } else {
                ansArr[k--] = y*y;
                j--;
            }
        }

        return ansArr;
    }
}
