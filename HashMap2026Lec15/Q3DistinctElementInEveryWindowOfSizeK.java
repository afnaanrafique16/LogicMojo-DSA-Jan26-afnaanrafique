package src.HashMap2026Lec15;

import java.util.HashMap;

public class Q3DistinctElementInEveryWindowOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        distinctElementsInEveryWindowOfSizeK(arr, k);
    }

    public static void distinctElementsInEveryWindowOfSizeK(int[] arr, int k) {
        int i=0, j=0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        while (j < arr.length) {
            int endWindowNum = arr[j];
            hashMap.put(endWindowNum, hashMap.getOrDefault(endWindowNum, 0) + 1);

            if (j-i+1 == k) {
                System.out.print(hashMap.size() + " ");
                int startWindowNum = arr[i];

                int count = hashMap.get(startWindowNum) - 1;
                if (count >= 1) {
                    hashMap.put(startWindowNum, count);
                } else {
                    hashMap.remove(startWindowNum);
                }

                i++;
            }

            j++;
        }
    }
}
