package src.Arrays2026BinarySearchLec7;

public class Q6CountOfElementsInASortedrray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        int target = 3;

        int ansCountOfElementsInASortedArray = countOfElementsInASortedArray(arr, target);
        System.out.println(ansCountOfElementsInASortedArray);
    }

    public static int countOfElementsInASortedArray(int[] arr, int target) {
        int[] ansFirstAndLastOccurence = firstAndLastOccurrence(arr, target);

        return ansFirstAndLastOccurence[1]-ansFirstAndLastOccurence[0]+1;

    }

    public static int[] firstAndLastOccurrence(int[] arr, int target) {
        int[] ans = new int[2];

        ans[0] = firstOccurrence(arr, target);
        ans[1] = lastOccurrence(arr, target);

        return ans;
    }

    public static int firstOccurrence(int[] arr, int target) {
        int i=0, j=arr.length-1;
        int first = -1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == target) {
                first = mid;
                j = mid-1;
            } else if (arr[mid] < target) {
                i = mid+1;
            } else {
                j=mid-1;
            }
        }

        return first;
    }

    public static int lastOccurrence(int[] arr, int target) {
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
