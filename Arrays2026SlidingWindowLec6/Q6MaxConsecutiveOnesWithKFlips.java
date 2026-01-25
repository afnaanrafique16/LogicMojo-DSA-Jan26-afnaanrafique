package src.Arrays2026SlidingWindowLec6;

public class Q6MaxConsecutiveOnesWithKFlips {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k=2;

        int ansMaxConsecutiveOnesOptimised = maxConsecutiveOneOptimised(nums, k);
        System.out.println(ansMaxConsecutiveOnesOptimised);
    }

    public static int maxConsecutiveOneOptimised(int[] arr, int k) {
        // i=> windowStart, j=>windowEnd
        int i=0, j=0;

        int maxLength = Integer.MIN_VALUE;
        // number of zeroes in that particular window
        int countZero=0;

        while (j < arr.length) {
            // initial work => as count of zero is the deciding factor for a valid window
            if (arr[j] == 0) {
                countZero++;
            }

            while (countZero > k) {
                if (arr[i] == 0) {
                    countZero--;
                }

                i++;
            }

            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }

        return maxLength;
    }
}
