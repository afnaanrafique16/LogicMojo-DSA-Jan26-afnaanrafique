package src.Arrays2026BinarySearchLec7;

public class Q7NumberOfTimesASortedArrayIsRotated {
    public static void main(String[] args) {
        //int[] arr = {15, 18, 2, 3, 6, 12};
        //int[] arr = {3,4,5,1,2};
        //int[] arr = {4,5,6,1,2,3};
        //int[] arr = {2,1,1,1,1};
        //int[] arr = {2,2,2,2,1,1};
        int[] arr = {4,5,1,2,3};

        int ansNumberOfTimesASortedArrayIsRotated = numberOfTimesASortedArrayIsRotataed(arr);
        System.out.println(ansNumberOfTimesASortedArrayIsRotated);


        int ans = rotationCountRight(arr);
        System.out.println(ans);
    }

    // for all questions
    public static int rotationCountRight(int[] arr) {
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


    // distinct elements
    public static int numberOfTimesASortedArrayIsRotataed(int[] arr) {
        int i = 0, j = arr.length - 1;

        while (i <= j) {
            if (arr[i] < arr[j]) return i;

            int mid = i + (j - i) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid - 1 + arr.length) % arr.length;

            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) return mid;

            if (arr[i] == arr[mid] && arr[mid] == arr[j]) {
                i++;
                j--;
                continue; // recompute mid etc.
            } else if (arr[i] <= arr[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return 0;
    }
}
