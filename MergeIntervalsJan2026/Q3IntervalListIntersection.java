package src.MergeIntervalsJan2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3IntervalListIntersection {
    public static void main(String[] args) {
//        int[][] firstList = {{1,3}, {5,6}, {7,9}};
//        int[][] secondList = {{2,3}, {5,7}};

        int[][] firstList = {{0,2}, {5,10}, {13,23}, {24,25}};
        int[][] secondList = {{1,5}, {8,12}, {15,24}, {25,26}};

        int[][] ansBruteForce = intervalIntersectionBruteForce(firstList, secondList);
        System.out.println(Arrays.deepToString(ansBruteForce));

        int[][] ansOptimised = intervalIntersectionOptimised(firstList, secondList);
        System.out.println(Arrays.deepToString(ansOptimised)); // [[2, 3], [5, 6], [7, 7]]
    }

    // O(n * m)
    public static int[][] intervalIntersectionBruteForce(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        // compare all the interval with every other interval
        for (int[] a : firstList) {
            for (int[] b : secondList) {

                // max of start time
                int overlapStart = Math.max(a[0], b[0]);
                // min of end time
                int overlapEnd = Math.min(a[1], b[1]);

                if (overlapStart <= overlapEnd) {
                    result.add(new int[]{overlapStart, overlapEnd});
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static int[][] intervalIntersectionOptimised(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i=0, j=0;

        while (i < firstList.length && j < secondList.length) {
            int firstStart = firstList[i][0];
            int firstEnd = firstList[i][1];

            int secondStart = secondList[j][0];
            int secondEnd = secondList[j][1];

            /*
            {1, 3}, {2, 5}
             */

            int overlapStart = Math.max(firstStart, secondStart);
            int overlapEnd = Math.min(firstEnd, secondEnd);


            // only add if there is an overlap
            if (overlapStart <= overlapEnd) {
                result.add(new int[] {overlapStart, overlapEnd});
            }

            // move the pointer of the interval that ends first
            // because there might be some more intersecting intervals gng fwd
            if (firstEnd < secondEnd) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
