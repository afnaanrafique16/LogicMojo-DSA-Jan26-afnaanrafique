package src.Arrays2026BinarySearchLec7;

public class Q2ReverseSortedArray {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 3, 2, 1};
        int target = 2;

        int ansReverseSortedArray = reverseSortedArray(arr, target);
        System.out.println(ansReverseSortedArray);
    }

    public static int reverseSortedArray(int[] arr, int num) {
        int i=0, j=arr.length-1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                // 5,4,3,2,1
                // discard lhs
                // move towards rhs
                i=mid+1;
            } else {
                // arr[mid] < num
                // discard rhs
                // move towards lhs
                j=mid-1;
            }
        }

        return -1;
    }
}
