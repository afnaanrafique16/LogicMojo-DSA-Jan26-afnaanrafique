package src.Arrays2026BinarySearchLec7;

import java.util.Arrays;

public class Q5FirstAndLastOccurenceInSortedArray {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;

        int[] ansFirstAndLastOccurence = firstAndLastOccurence(arr, target);
        System.out.println(Arrays.toString(ansFirstAndLastOccurence));
    }

    public static int[] firstAndLastOccurence(int[] arr, int target) {
        int[] ans = new int[2];

        ans[0] = firstOccurence(arr, target);
        ans[1] = lastOccurence(arr, target);

        return ans;
    }

    public static int firstOccurence(int[] arr, int target) {
        int i=0, j=arr.length-1;
        int first = -1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == target) {
                first = mid;
                j = mid-1;  // go to the left in order to find a better result
            } else if (arr[mid] < target) {
                // discard all the left values
                i = mid+1;
            } else {
                // discard all the right values
                j=mid-1;
            }
        }

        return first;
    }

    public static int lastOccurence(int[] arr, int target) {
        int i=0, j=arr.length-1;
        int last = -1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == target) {
                last = mid;
                i = mid+1;
            } else if (arr[mid] < target) {
                i = mid+1;
            } else {
                j=mid-1;
            }
        }

        return last;
    }


}
