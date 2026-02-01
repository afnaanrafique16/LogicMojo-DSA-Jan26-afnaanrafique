package src.Arrays2026BinarySearchLec7;

public class Q12IndexOfFirstOneInInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,1,1,1,1};

        int ansFirstOne = firstOne(arr);
        System.out.println(ansFirstOne);
    }

    public static int firstOne(int[] arr) {
        int i=0, j=1;

        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0] == 1 ? 0 : -1;

        while (j < arr.length && arr[j] == 0) {
            i = j;
            j = j*2;
        }

        //if (j >= arr.length) j = arr.length - 1;

        return firstOccurrence(arr, 1, i, j);
    }

    public static int firstOccurrence(int[] arr, int target, int i, int j) {
        int first = -1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == target) {
                // grep the target and look for better result on the left
                first = mid;
                j = mid-1;
            } else if (arr[mid] < target) {
                // normal BS
                i = mid+1;
            } else {
                // normal BS
                j=mid-1;
            }
        }

        return first;
    }
}
