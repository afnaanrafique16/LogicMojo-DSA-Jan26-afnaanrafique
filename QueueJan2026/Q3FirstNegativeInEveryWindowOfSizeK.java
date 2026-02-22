package src.QueueJan2026;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q3FirstNegativeInEveryWindowOfSizeK {
    public static void main(String[] args) {
//        int[] arr = {-8, 2, 3, -6, 10};
//        //int k = 2;
//        int k = 3;

        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k=3;

        int[] ansFirstNegativeInEveryWindowOfSizeK = firstNegativeInEveryWindowOfSizeK(arr, k);
        System.out.println(Arrays.toString(ansFirstNegativeInEveryWindowOfSizeK));
    }

    public static int[] firstNegativeInEveryWindowOfSizeK(int[] arr, int k) {
        int[] ans = new int[arr.length-k+1];
        int i=0, j=0;  // windowStart, windowEnd

        // Queue holds all the negative numbers of that particular window
        Queue<Integer> queue = new LinkedList<>();
        int p=0;

        while (j <arr.length) {
            // Initial work
            // if number at j's location is negative add it into the queue
            if (arr[j] < 0) {
                queue.add(arr[j]);
            }

            // Main work
            // If u hv reached the window threshold
            if (j-i+1 == k) {
                if (!queue.isEmpty()) {
                    ans[p++] = queue.peek();
                } else {
                    ans[p++] = 0;
                }

                // if the queue's peek is the element pointed by windowStart =>
                // remove it as it will not be present when we slide
                // the window
                if (!queue.isEmpty() && arr[i] == queue.peek()) {
                    // remove the first element from the queue
                    queue.poll();
                }

                // move the windowStart pointer ahead
                i++;
            }

            // move the windowEnd pointer ahead
            j++;
        }

        return ans;

    }
}
