package src.Arrays2026BinarySearchLec7;

public class Q1BinarySearch {
    public static void main(String[] args) {
        // in ascending order
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 2;

        int ansIndexBinarySeach = indexBinarySearch(arr, target);
        System.out.println(ansIndexBinarySeach);
    }

    public static int indexBinarySearch(int[] arr, int num) {
        int i=0, j=arr.length-1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                // 1, 2, 3, 4, 5; target = 1
                // discard RHS
                // move towards left
                j=mid-1;
            } else {
                // arr[mid] < num
                // discard LHS
                // move towards right
                i=mid+1;
            }
        }

        return -1;
    }
}
