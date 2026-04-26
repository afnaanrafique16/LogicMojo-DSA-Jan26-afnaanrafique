package src.HeapJan2026;

import java.util.*;

public class Q5FrequencySort {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3};

        int[] ansArr = freqSortFun(arr);
        System.out.println(Arrays.toString(ansArr));
    }

    public static int[] freqSortFun(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] ansArr = new int[arr.length];
        int p=0;

        for (int i=0; i<arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        // min heap
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>((a, b) -> {

                    // if same values take larger value, discard the smaller value
                    if (a.getValue().equals(b.getValue())) {
                        return b.getKey() - a.getKey(); // larger number first
                    }

                    // otherwise take the smaller frequency we want it to get polled first
                    return a.getValue() - b.getValue(); // smaller frequency first
                });

        // add hashmap's entry into pq
        /*
        Or iterate over the array and keep on adding in the priority queue
         */
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            priorityQueue.add(entry);
        }

        while (!priorityQueue.isEmpty()) {
            int freq = priorityQueue.peek().getValue();
            int num = priorityQueue.peek().getKey();

            for (int i=0; i<freq; i++) {
                ansArr[p++] = num;
            }
            priorityQueue.poll();
        }

        return ansArr;
    }
}
