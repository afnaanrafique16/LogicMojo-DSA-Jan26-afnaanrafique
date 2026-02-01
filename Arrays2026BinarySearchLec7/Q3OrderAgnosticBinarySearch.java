package src.Arrays2026BinarySearchLec7;

public class Q3OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        //int[] arr = {10, 6, 4};
        //int target = 10;
        int[] arr = {1, 2, 3, 4};
        int target = 3;


        int ansOrderAgnosticBinarySearch = orderAgnosticBinarySearch(arr, target);
        System.out.println(ansOrderAgnosticBinarySearch);
    }

    public static int orderAgnosticBinarySearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        boolean isAscending = arr[0] < arr[arr.length - 1];

        if (isAscending) {
            int ans = normalBinarySearch(arr, target);
            return ans;
        } else {
            int ans = reverseSortedArray(arr, target);
            return ans;

        }
    }

    public static int reverseSortedArray(int[] arr, int num) {
        int i=0, j=arr.length-1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                i=mid+1;
            } else {
                j=mid-1;
            }
        }

        return -1;
    }

    public static int normalBinarySearch(int[] arr, int num) {
        int i=0, j=arr.length-1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                // towards left
                j=mid-1;
            } else {
                // towards right
                i=mid+1;
            }
        }

        return -1;
    }
}
