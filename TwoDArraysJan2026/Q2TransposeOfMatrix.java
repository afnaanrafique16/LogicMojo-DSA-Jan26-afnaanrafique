package src.TwoDArraysJan2026;

import java.util.Arrays;

public class Q2TransposeOfMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        transposeOfMatrix(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public static void transposeOfMatrix(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}
