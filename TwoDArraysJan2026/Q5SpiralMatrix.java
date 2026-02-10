package src.TwoDArraysJan2026;

public class Q5SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };

        spiralMatrixTraversal(arr);
    }

    public static void spiralMatrixTraversal(int[][] arr) {
        int top=0, bottom=arr.length-1;
        int left=0, right=arr[0].length-1;
        int direction=0;

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                // L-R
                for (int i=left; i<=right; i++) {
                    System.out.print(arr[top][i] + " ");
                }
                top++;
            } else if (direction == 1) {
                // T-B
                for (int i=top; i<=bottom; i++) {
                    System.out.print(arr[i][right] + " ");
                }
                right--;
            } else if (direction == 2) {
                // R-L
                for (int i=right; i>=left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            } else {
                // B-T
                for (int i=bottom; i>=top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }

            direction = (direction+1) % 4;
        }
    }
}
