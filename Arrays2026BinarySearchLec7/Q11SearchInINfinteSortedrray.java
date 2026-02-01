package src.Arrays2026BinarySearchLec7;

public class Q11SearchInINfinteSortedrray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 8;

        int ansInfiniteSortedArray = infiniteSortedArray(arr, key);
        System.out.println(ansInfiniteSortedArray);
    }

    public static int infiniteSortedArray(int[] arr, int key) {
        int i=0, j=1;

        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0] == key ? 0 : -1;

        // O(logn)
        while (arr[j] <= key) {
            i = j;
            j = j*2;
        }

        // O(logn)
        return binarySearch(arr, i, j, key);
    }

    public static int binarySearch(int[] arr, int i, int j, int key) {
        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                j=mid-1;
            } else {
                i=mid+1;
            }
        }

        return -1;
    }
}
