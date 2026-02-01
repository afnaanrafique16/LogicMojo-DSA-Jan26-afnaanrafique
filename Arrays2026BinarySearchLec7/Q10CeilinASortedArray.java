package src.Arrays2026BinarySearchLec7;

public class Q10CeilinASortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 10, 10, 12};
        int num=9;

        int ansCeilInSortedArray = ceilInSortedArray(arr, num);
        System.out.println(ansCeilInSortedArray);
    }

    public static int ceilInSortedArray(int[] arr, int num) {
        int i=0, j=arr.length-1;
        int res=-1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] < num) {
                i=mid+1;
            } else {
                res=mid;
                j=mid-1;
            }
        }

        return arr[res];

    }

}
