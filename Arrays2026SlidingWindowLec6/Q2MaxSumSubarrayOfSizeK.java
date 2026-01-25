package src.Arrays2026SlidingWindowLec6;

public class Q2MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 7, 5};
        int k=3;

        int ansMaxSumSubarrayOfSizeKBruteForce = maxSumSubarrayOfSizeKBruteForce(arr, k);
        System.out.println(ansMaxSumSubarrayOfSizeKBruteForce);

        int ansMaxSumSubarrayOfSizeKOptimised = maxSumSubarrayOfSizeKOptimised(arr, k);
        System.out.println(ansMaxSumSubarrayOfSizeKOptimised);
    }

    public static int maxSumSubarrayOfSizeKBruteForce(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i<=arr.length-k; i++) {
            int currentWindowSum=0;

            for (int j=i; j<i+k; j++) {
                currentWindowSum += arr[j];
            }
            maxSum = Math.max(maxSum, currentWindowSum);
        }

        return maxSum;
    }

    // sliding window
    public static int maxSumSubarrayOfSizeKOptimised(int[] arr, int k) {
        int i=0, j=0;
        int currentWindowSum=0, maxSum = Integer.MIN_VALUE;

        while (j < arr.length) {
            // initial work
            currentWindowSum += arr[j];

            // main work
            if (j-i+1 == k) {
                maxSum = Math.max(maxSum, currentWindowSum);
                // shrink the window
                currentWindowSum -= arr[i];
                i++;
            }

            j++;
        }

        return maxSum;
    }
}
