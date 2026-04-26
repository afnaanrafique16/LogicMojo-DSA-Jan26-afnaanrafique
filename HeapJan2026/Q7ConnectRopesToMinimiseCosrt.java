package src.HeapJan2026;

import java.util.PriorityQueue;

public class Q7ConnectRopesToMinimiseCosrt {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int ansConnectRopesToMinimiseCost = connectRopesToMinimiseCost(arr);
        System.out.println(ansConnectRopesToMinimiseCost);
    }

    // at any time take teo min ropes
    public static int connectRopesToMinimiseCost(int[] arr) {
        int ans=0;

        // create a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0; i<arr.length; i++) {
            minHeap.add(arr[i]);
        }

        while (minHeap.size() >= 2) {
            int num1 = minHeap.poll();
            int num2 = minHeap.poll();

            int total = num1 + num2;
            ans += total;

            minHeap.add(total);
        }

        return ans;
    }
}
