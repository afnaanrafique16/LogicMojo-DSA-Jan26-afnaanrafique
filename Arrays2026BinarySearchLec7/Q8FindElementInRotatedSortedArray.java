package src.Arrays2026BinarySearchLec7;

public class Q8FindElementInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        int target = 4;

        int ansFindElementInRotatedSortedArray = findElementInRotatedSortedArray(arr, target);
        System.out.println(ansFindElementInRotatedSortedArray);

        int ansFindElementInRotatedSortedArrayMinIndex = findElementInRotatedSortedArrayMinIndex(arr, target);
        System.out.println(ansFindElementInRotatedSortedArrayMinIndex);
    }

    public static int findElementInRotatedSortedArrayMinIndex(int[] arr, int target) {
        // all the elements to the left and right of this are sorted
        // partition
        int minIndex = numberOfTimesASortedArrayIsRotataed(arr);
        int i=0, j=arr.length-1;

        if (target >= arr[minIndex] && target <= arr[j]) {
            // lying on the RHS
            // apply binary search on the portion where this target can lie.
            // target greater than min index and target smaller last element in second half
            return binarySearch(arr, minIndex, j, target);
        } else {
            // in first half
            return binarySearch(arr, i, minIndex-1, target);
        }

    }

    public static int numberOfTimesASortedArrayIsRotataed(int[] arr) {
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] > arr[j]) {
                i = mid + 1;      // min is in right half
            } else if (arr[mid] < arr[j]) {
                j = mid;          // min is at mid or in left half
            } else {
                j--;              // cannot decide, shrink safely
            }
        }
        return i; // index of minimum (rotation count)
    }

    public static int binarySearch(int[] arr, int i, int j, int target) {
        while (i<=j) {
            int mid = i+ (j-i)/2;

            if (arr[mid] > target) {
                j= mid-1;
            } else if (arr[mid] == target) {
                return mid;
            } else {
                i=mid+1;
            }
        }

        return -1;
    }

    public static int findElementInRotatedSortedArray(int[] arr, int target) {
        int i=0, j=arr.length-1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == target) {
                return mid;
            }

            // check which side is sorted
            if (arr[i] <= arr[mid]) {
                //lhs is sorted
                // see if element is present in sorted lhs
                if (arr[i] <= target && target < arr[mid]) {
                    j=mid-1;
                } else {
                    i=mid+1;
                }
            } else {
                //rhs is sorted
                //see if present in sorted rhs
                if (arr[mid] < target && target <=arr[j]) {
                    i=mid+1;
                } else {
                    j=mid-1;
                }
            }
        }

        return -1;

    }
}
