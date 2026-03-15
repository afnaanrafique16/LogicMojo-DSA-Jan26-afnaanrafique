package src.RecursionJan2026;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 2;

        int ansBinarySearchRecurSive = binarySearchRecursive(arr, 0, arr.length-1, target);
        System.out.println(ansBinarySearchRecurSive);
    }

    public static int binarySearchRecursive(int[] arr, int l, int r, int target) {

        while (l < r) {
            int mid = l + (r-l)/2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                int ans = binarySearchRecursive(arr, mid+1, r, target);
                return ans;
            } else {
                int ans = binarySearchRecursive(arr, l,mid-1,target);
                return ans;
            }
        }

        return -1;
    }
}
