package src.HeapJan2026;

import java.util.*;

public class Q4TopKFrequentNumbers {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int k=2;

        int[] ansTopKFrequentElements = topKFrequentElements(arr, k);
        System.out.println(Arrays.toString(ansTopKFrequentElements));
    }

    public static int[] topKFrequentElements(int[] arr, int k) {
        int[] ansArr = new int[k];

        // element -> count
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        /*
        We want the larger values, hence we want to get rid of smaller values
        hence make min heap on the basis of frequencies.
         */

        // min heap on the basis of hashmap's values
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.getValue()));

        // add frequencies inside the hashmap
        for (int i=0; i<arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        // iterate over hashmap's values and keep the top k frequent elements at each level
        for (Map.Entry<Integer, Integer> entry:hashMap.entrySet()) {
            priorityQueue.add(entry);

            // pq size > k, poll the elements from the pq
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        // poll the remaining elements Key from the pq and put it inside array.
        int p=0;
        while (!priorityQueue.isEmpty()) {
            ansArr[p++] = priorityQueue.poll().getKey();
        }

        return ansArr;

    }
}
