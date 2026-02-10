package src.TwoDArraysJan2026;

public class Q4WaveTraversal {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };


        waveTraversal(arr);
        System.out.println();

        waveTraversalRowWise(arr);
        System.out.println();
    }

    public static void waveTraversal(int[][] arr) {
        for (int j=0; j<arr[0].length; j++) {
            if (j % 2 == 0) {
                // T-B
                for (int i=0; i<arr.length; i++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                // B-T
                for (int i=arr.length-1; i>=0; i--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }

    public static void waveTraversalRowWise(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            if (i % 2 == 0) {
                //R-L
                for (int j=arr[0].length-1; j>=0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                //L-R
                for (int j=0; j<arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }
}
