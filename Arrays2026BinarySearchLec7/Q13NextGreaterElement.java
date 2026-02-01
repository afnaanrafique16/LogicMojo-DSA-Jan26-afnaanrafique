package src.Arrays2026BinarySearchLec7;

// Ceil in case of strings
public class Q13NextGreaterElement {
    public static void main(String[] args) {
        char[] letter = {'c', 'f', 'j'};
        char target = 'a';

        char ansNExtGreaterElement = nextGreaterElement(letter, target);
        System.out.println(ansNExtGreaterElement);
    }

    public static char nextGreaterElement(char[] arr, char target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int i=0, j=arr.length-1;
        int res=-1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            int asciiMid = arr[mid];
            int asCiiTarget = target;

            if (asciiMid >= asCiiTarget) {
                res = mid;
                j=mid-1;
            } else {
                i=mid+1;
            }
        }

        return res == -1 ? arr[0] : arr[res];
    }
}
