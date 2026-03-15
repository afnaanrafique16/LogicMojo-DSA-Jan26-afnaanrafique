package src.RecursionJan2026;

public class Q7BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 1;

        int ansBinarySeachIterative = binarySearchIterative(arr, target);
        System.out.println(ansBinarySeachIterative);

        int ansBinarySearchRecursive = binarySearchRecursive(arr, target, 0, arr.length-1);
        System.out.println(ansBinarySearchRecursive);
    }

    public static int binarySearchIterative(int[] arr, int target) {
        int i=0, j=arr.length-1;

        while (i <= j) {
            int mid = i + (j-i)/2;
            if (arr[mid] > target) {
                j=mid-1;
            } else if (arr[mid] < target) {
                i=mid+1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int target, int i, int j) {
        if (i > j) {
            return -1;
        }

        int mid = i + (j-i)/2;

        if (arr[mid] > target) {
            int ans = binarySearchRecursive(arr, target, i, mid-1);
            return ans;
        } else if (arr[mid] < target) {
            int ans = binarySearchRecursive(arr, target, mid+1, j);
            return ans;
        } else {
            return mid;
        }
    }
}
