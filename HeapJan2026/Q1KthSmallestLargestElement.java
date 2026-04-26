package src.HeapJan2026;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q1KthSmallestLargestElement {
    public static void main(String[] args) {
        //int[] arr = {7, 10, 4, 3, 20, 15};
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 3;

        int ansKthSmallestElement = kthSmallestElement(arr, k);
        System.out.println(ansKthSmallestElement);

        int ansKthLargestElement = kthLargestElement(arr, k);
        System.out.println(ansKthLargestElement);
    }

    public static int kthSmallestElement(int[] arr, int k) {

        //kth smallest -> max heap
        //PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b-a);

        for (int i=0; i<arr.length; i++) {
            // adding array elements inside max heap
            priorityQueue.add(arr[i]);

            // the moment max heap's size > k => poll from pq
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        // pq peek should contain the kth smallest element.
        return priorityQueue.peek();

    }

    public static int kthLargestElement(int[] arr, int k) {
        // kthlargest => min heap
        //PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> a-b);

        for (int i=0; i<arr.length; i++) {
            priorityQueue.add(arr[i]);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }
}
