package src.TwoDArraysJan2026;

import java.util.Arrays;

public class Q6RotateImage {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        // printing in one line
        System.out.println(Arrays.deepToString(arr));

        rotateImage(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public static void rotateImage(int[][] arr) {
        //1. Transpose

        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i=0; i<arr.length; i++) {
            int left=0, right=arr.length-1;

            while (left <= right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
