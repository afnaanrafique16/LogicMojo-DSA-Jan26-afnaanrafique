package src.Arrays2026TwoPointerLec5;

public class Q2RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 6, 9, 9};

        int ansRemoveDupFromSortedArrayBruteForce = removeDuplicateFromSortedArrayBF(arr);
        System.out.println(ansRemoveDupFromSortedArrayBruteForce);

        int ansRemoveDupOptimised = removeDupOptimised(arr);
        System.out.println(ansRemoveDupOptimised);
    }

    public static int removeDuplicateFromSortedArrayBF(int[] arr) {

        // if there is only one number that is ought to be unique, and if no number -> NO unique
        if (arr.length <= 1) {
            return arr.length;
        }

        int k=0;
        int[] ansArr = new int[arr.length];
        ansArr[k++] = arr[0];

        for (int i=1; i<arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                ansArr[k++] = arr[i];
            }
        }

        return k;
    }

    public static int removeDupOptimised(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }

        int i=0, j=1;

        while (j < arr.length) {
            // immediate before one => because if it is equal 100% this is a duplicate value
            if (arr[j] == arr[j-1]) {
                j++;
            } else {
                i++;
                arr[i] = arr[j];
                j++;
            }
        }

        /*
        while (j < arr.length) {
            if (arr[j] != arr[j-1]) {
                i++;
                arr[i] = arr[j];
            }

            j++;
        }
         */

        // return the number of unique elements -> i+1
        return i+1;
    }
}
