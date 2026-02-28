package src.HashMap2026Lec15;

import java.util.HashMap;
import java.util.Map;

public class Q2LongestSubarrayWithZeroSum {
    public static void main(String[] args) {
        //int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] arr = {-1, 3, 2, -2, -3, 3};

        int ansLongestSubarrayWithZeroSum = longestSubarrayWithZeroSum(arr);
        System.out.println(ansLongestSubarrayWithZeroSum);
    }

    public static int longestSubarrayWithZeroSum(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int j=0;
        int currentSum=0;
        int maxLength = 0;
        hashMap.put(0, -1);

        while (j < arr.length) {
            currentSum += arr[j];

            if (!hashMap.containsKey(currentSum)) {
                hashMap.put(currentSum, j);
            } else {
                /*
                A      B     C
                AB=5
                AC=5
                => BC=0
                 */

                maxLength = Math.max(maxLength, j-hashMap.get(currentSum));
            }

            j++;
        }

        return maxLength;
    }

}
