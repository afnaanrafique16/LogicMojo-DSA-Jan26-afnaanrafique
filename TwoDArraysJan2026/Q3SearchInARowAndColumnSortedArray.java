package src.TwoDArraysJan2026;

public class Q3SearchInARowAndColumnSortedArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17},
        };

        int target = 9;

        boolean ansSearchBruteForce = searchBruteForce(arr, target);
        System.out.println(ansSearchBruteForce);

        boolean ansSearchBinarySearch = searchBinarySearch(arr, target);
        System.out.println(ansSearchBinarySearch);

        boolean ansStairCaseOptimisation = staircaseoptimisation(arr, target);
        System.out.println(ansStairCaseOptimisation);
    }

    public static boolean staircaseoptimisation(int[][] arr, int target) {
        int i=0, j=arr.length-1;
        
        while (i<arr.length && j>=0) {
            if (arr[i][j] == target) {
                return true;
            } else if (arr[i][j] < target) {
                i++;
            } else {
                // arr[i][j] > target
                j--;
            }
        }

        return false;
    }

    public static boolean searchBruteForce(int[][] arr, int target) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean searchBinarySearch(int[][] arr, int target) {
        for (int i=0; i<arr.length; i++) {
            if (binarySeachOnColumn(arr[i], target)) {
                return true;
            }
        }

        return false;
    }

    public static boolean binarySeachOnColumn(int[] arr, int target) {
        int i=0, j=arr.length-1;

        while (i <= j) {
            int mid = i + (j-i)/2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                // 1, 2, 3, 5
                j=mid-1;
            } else {
                i=mid+1;
            }
        }

        return false;
    }
}
