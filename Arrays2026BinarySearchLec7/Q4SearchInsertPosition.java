package src.Arrays2026BinarySearchLec7;

public class Q4SearchInsertPosition {
    public static void main(String[] args) {
//        int[] arr = {1,3,5,6};
//        int target = 2;

        int[] arr = {1,2,4,5,6};
        int target = 3;

        int ansSearchInsertPositionAscending = searchInsertPositionAscending(arr, target);
        System.out.println(ansSearchInsertPositionAscending);

        int ansSearchInsertPositionAscendingCeil = searchInsertPositionAscendingCeil(arr, target);
        System.out.println(ansSearchInsertPositionAscendingCeil);

        int ansSearchInsertPositionDescending = searchInsertPositionDescending(new int[]{7,6,5,3}, 1);
        System.out.println(ansSearchInsertPositionDescending);
    }

    public static int searchInsertPositionDescending(int[] arr, int target) {
        int i=0, j=arr.length-1;
        int ans = -1;

        // 7,6,5,3,1
        // target = 2
        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] > target) {
                // discard lhs
                i=mid+1;
            } else {
                ans = mid;
                j=mid-1;
            }
        }

        // 7,6,5,3 ; target = 1
        return ans == -1 ? arr.length : ans;
    }

    public static int searchInsertPositionAscendingCeil(int[] arr, int target) {
        int i=0, j=arr.length-1;
        int ans = -1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] >= target) {
                ans = mid;
                j=mid-1;
            } else {
                // arr[mid] < target
                // discard lhs
                i=mid+1;
            }
        }

        return ans == -1 ? arr.length : ans;
    }

    public static int searchInsertPositionAscending(int[] arr, int target) {
        int i=0, j=arr.length-1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                i=mid+1;
            } else {
                j=mid-1;
            }
        }

        return i;
    }

}
