package src.Arrays2026BinarySearchLec7;

public class Q9FloorInASortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 10};
        int target=9;

        int ansFloorInASortedArray = floorInASortedArray(arr, target);
        System.out.println(ansFloorInASortedArray);
    }

    public static int floorInASortedArray(int[] arr, int target) {
        int i=0, j=arr.length-1;
        int ans=-1;

        while (i<=j) {
            int mid = i+(j-i)/2;

            if (arr[mid] <= target) {
                ans = mid;  // potentialAnswer
                i=mid+1;    // move towards right to see if we can hv a better answer
            } else {
                // discard rhs
                j=mid-1;
            }
        }

        return arr[ans];
    }
}
