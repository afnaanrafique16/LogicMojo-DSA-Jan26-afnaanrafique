package src.HashMap2026Lec15;

import java.util.Arrays;
import java.util.HashMap;

public class Q1TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] ansTwoSumHashMap = twoSumHashMap(arr, target);
        System.out.println(Arrays.toString(ansTwoSumHashMap));
    }

    public static int[] twoSumHashMap(int[] arr, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            int counterPart = target - arr[i];

            if (!hashMap.containsKey(counterPart)) {
                // element -> index
                hashMap.put(arr[i], i);
            } else {
                // return the index, counterparts index
                return new int[]{hashMap.get(counterPart), i};
            }
        }

        return new int[]{};
    }
}
