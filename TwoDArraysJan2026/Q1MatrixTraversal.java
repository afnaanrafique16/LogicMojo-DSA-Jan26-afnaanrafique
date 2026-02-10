package src.TwoDArraysJan2026;

public class Q1MatrixTraversal {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


        printRowWise(arr);
        System.out.println();

        printColumnWise(arr);
        System.out.println();

        reverseRowWise(arr);
        System.out.println();

        reverseColumnWise(arr);
        System.out.println();
    }

    public static void printRowWise(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    public static void printColumnWise(int[][] arr) {
        for (int j=0; j<arr[0].length; j++) {
            for (int i=0; i<arr.length; i++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    public static void reverseRowWise(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=arr[0].length-1; j>=0; j--) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    public static void reverseColumnWise(int[][] arr) {
        for (int j=arr[0].length-1; j>=0; j--) {
            for (int i=0; i<arr.length; i++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
