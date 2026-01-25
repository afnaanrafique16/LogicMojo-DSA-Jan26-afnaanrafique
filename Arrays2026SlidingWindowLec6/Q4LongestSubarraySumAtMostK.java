package src.Arrays2026SlidingWindowLec6;

public class Q4LongestSubarraySumAtMostK {
    public static void main(String[] args) {
        //int[] arr = {2, 1, 5, 2, 3};
        int[] arr = {4, 1, 1, 1, 2, 3};
        int k=5;

        int ansLongestSubaaraySumBruteForce = longestSubarraySumBruteForce(arr, k);
        System.out.println(ansLongestSubaaraySumBruteForce);

        int ansLongestSubarrayOptimised = longestSubarraySumOptimised(arr, k);
        System.out.println(ansLongestSubarrayOptimised);
    }

    public static int longestSubarraySumBruteForce(int[] arr, int k) {
        int maxLen = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {
            int currentWindowSum=0;
            for (int j=i; j<arr.length; j++) {
                currentWindowSum += arr[j];

                if (currentWindowSum <= k) {
                    maxLen = Math.max(maxLen, j-i+1);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }

    public static int longestSubarraySumOptimised(int[] arr, int k) {
        int i=0, j=0, currentWindowSum=0, maxLength = Integer.MIN_VALUE;

        while (j < arr.length) {
            // initial work
            currentWindowSum += arr[j];

            // shrink the window when it is not valid
            while (currentWindowSum > k) {
                // subtract the value that is being pointed by the first index
                currentWindowSum -= arr[i];
                // increment the windowStart
                i++;
            }

            // calculate maxLength
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }

        return maxLength;
    }
}
