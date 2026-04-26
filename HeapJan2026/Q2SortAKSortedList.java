package src.HeapJan2026;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2SortAKSortedList {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k=3;

        int[] ansKSortedList = kSortedListFun(arr, k);
        System.out.println(Arrays.toString(ansKSortedList));
    }

    public static int[] kSortedListFun(int[] arr, int k) {
        int[] ansArr = new int[arr.length];
        int p=0;

        //minheap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i=0; i<arr.length; i++) {
            priorityQueue.add(arr[i]);

            // whenever we are standing at k+1'th location
            if (priorityQueue.size() > k) {
                // add the topmost element in the array
                ansArr[p++] = priorityQueue.poll();
            }
        }

        // add the remaining elements of priority queue in the ansArr
        while (!priorityQueue.isEmpty()) {
            ansArr[p++] = priorityQueue.poll();
        }

        return ansArr;
    }
}
