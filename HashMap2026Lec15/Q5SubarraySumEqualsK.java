package src.HashMap2026Lec15;

import java.util.HashMap;

public class Q5SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, 0, 0};
        int k = 3;

        int ansSubarraySumEqualsK = subArraySumEqualsK(arr, k);
        System.out.println(ansSubarraySumEqualsK);
    }

    public static int subArraySumEqualsK(int[] arr, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int currentSum = 0;
        int count = 0;

        for (int i=0; i<arr.length; i++) {
            currentSum += arr[i];

            count += hashMap.getOrDefault(currentSum - k, 0);

            hashMap.put(currentSum, hashMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
