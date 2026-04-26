package src.HeapJan2026;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q6KClosestPointsToOrigin {
    public static class XYPair {
        int x;
        int y;

        XYPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Pair {
        // Euclidean distance
        int dis;
        XYPair xyPair;

        Pair(int dis, XYPair xyPair) {
            this.dis = dis;
            this.xyPair = xyPair;
        }
    }
    public static void main(String[] args) {
//        int[][] arr = {
//                {1, 3},
//                {-2, 2},
//                {5, 8},
//                {0, 1}
//        } ;
//        int k = 2;

        int[][] arr = {
                {1, 3},
                {-2, 2}
        } ;
        int k = 1;

        List<int[]> ansKClosestPointsToOrigin = kClosestPointsToOrigin(arr, k);
        //System.out.println(ansKClosestPointsToOrigin);
        for (int[] point : ansKClosestPointsToOrigin) {
            System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }

    public static List<int[]> kClosestPointsToOrigin(int[][] arr, int k) {

        // We need to create max heap to store (x^2 + y^2), {x, y} => Pair <Int, Pair<x, y>>
        // PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.dis - a.dis);
        /*
        we want smaller values => hence get rid of larger values => create max heap on the basis of distance
         */

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.dis).reversed());
        List<int[]> result = new ArrayList<>();

        for (int i=0; i<arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];

            int distance = (x * x) + (y * y);
            maxHeap.add(new Pair(distance, new XYPair(x, y)));

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // add the xy pair inside the list
        while (!maxHeap.isEmpty()) {
            Pair pair =  maxHeap.poll();
            result.add(new int[]{pair.xyPair.x, pair.xyPair.y});
        }

        return result;
    }
}
