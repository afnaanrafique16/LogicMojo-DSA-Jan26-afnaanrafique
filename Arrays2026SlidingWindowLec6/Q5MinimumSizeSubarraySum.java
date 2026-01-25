package src.Arrays2026SlidingWindowLec6;

public class Q5MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;

        int ansMinimumSizeSubarrayBruteForce = minimumSizeSubarrayBruteForce(arr, target);
        System.out.println(ansMinimumSizeSubarrayBruteForce);

        int ansMinimumSizeSubarraySumOptimised = minimumSizeSubarraySumOptimised(arr, target);
        System.out.println(ansMinimumSizeSubarraySumOptimised);
    }

    public static int minimumSizeSubarrayBruteForce(int[] arr, int target) {
        int minLength = Integer.MAX_VALUE;

        for (int i=0; i<arr.length; i++) {
            int currentWindowSum = 0;
            for (int j=i; j<arr.length; j++) {
                currentWindowSum += arr[j];

                if (currentWindowSum >= target) {
                    minLength = Math.min(minLength, j-i+1);
                }
            }
        }

        return minLength;
    }

    public static int minimumSizeSubarraySumOptimised(int[] arr, int target) {
        int i=0, j=0;
        int minLength = Integer.MAX_VALUE;
        int currentWindowSum = 0;

        while (j < arr.length) {
            currentWindowSum += arr[j];

            while (currentWindowSum >= target) {
                minLength = Math.min(minLength, j-i+1);
                currentWindowSum-=arr[i];
                i++;
            }
            j++;
        }

        return minLength == Integer.MAX_VALUE ? 0: minLength;
    }
}
