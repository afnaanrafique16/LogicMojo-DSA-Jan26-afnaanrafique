package src.HeapJan2026;

import java.util.*;

public class Q3KclosestNumbers {
    public static class Pair {
        int absValue;
        int arrValue;

        Pair(int absValue, int arrValue) {
            this.absValue = absValue;
            this.arrValue = arrValue;
        }
    }

    public static void main(String[] args) {
        //int[] arr = {1,2,3,4,5};
//        int k = 4;
//        int x = 3;

        int[] arr = {1,1,2,3,4,5};
        int k = 4;
        int x = -1;

        List<Integer> ansList = findClosestElementsFun(arr, k, x);
        System.out.println(ansList);
    }

    public static List<Integer> findClosestElementsFun(int[] arr, int k, int x) {
        List<Integer> ansList = new ArrayList<>();

        // max heap
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a,b) -> {
            // if both are equally far, we want smaller number as the ans hence
            // we add the bigger number in the heap
            if (a.absValue == b.absValue) {
                return b.arrValue - a.arrValue;
            }

            return b.absValue-a.absValue;
        }
        );

        for (int i=0; i<arr.length; i++) {
            // absValue -> arrValue
            priorityQueue.add(new Pair(Math.abs(arr[i] - x), arr[i]));

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        // add the arrValues to the list
        while (!priorityQueue.isEmpty()) {
            ansList.add(priorityQueue.poll().arrValue);
        }

        // sort the list
        Collections.sort(ansList);

        return ansList;

    }
}
