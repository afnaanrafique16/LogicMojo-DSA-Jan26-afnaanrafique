package src.Arrays2026BinarySearchLec7;

public class MinimumDifferenceElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 15};
        int key = 12;

        int ansMinimumDifferenceElementInSortedArray = minimumElementDiffInSortedArray(arr, key);
        System.out.println(ansMinimumDifferenceElementInSortedArray);
    }

    public static int minimumElementDiffInSortedArray(int[] arr, int key) {
        int floor = floorFun(arr, key);
        int ceil = ceilFun(arr, key);

        int floorDiff = Math.abs(floor-key);
        int ceilDiff = Math.abs(ceil-key);

        if (floorDiff < ceilDiff) {
            return floor;
        } else {
            return ceil;
        }
    }

    public static int ceilFun(int[] arr, int key) {
         int i=0, j=arr.length-1;
         int ans=-1;

         while (i <= j) {
             int mid = i + (j-i)/2;

             if (arr[mid] < key) {
                 i = mid+1;
             } else {
                 ans = mid;
                 j=mid-1;
             }
         }

         return arr[ans];
    }

    public static int floorFun(int[] arr, int key) {
        int i=0, j=arr.length-1;
        int ans=-1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] <= key) {
                ans = mid;
                i=mid+1;
            } else {
                j=mid-1;
            }
        }

        return arr[ans];
    }
}
