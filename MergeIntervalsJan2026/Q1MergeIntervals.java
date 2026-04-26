package src.MergeIntervalsJan2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q1MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4},
                {2, 3},
                {5, 7},
                {6, 8}
        };

//        int[][] arr = {
//                {1, 3},
//                {2, 6},
//                {5, 12},
//                {8, 10},
//                {15, 18}
//        };

        int[][] ansMergeIntervalBruteForce = mergeIntervalBruteForce(arr);
        System.out.println(Arrays.deepToString(ansMergeIntervalBruteForce));

        int[][] ansMergeIntervalsOptimsed = mergedIntervalsOptimsed(arr);
        System.out.println(Arrays.deepToString(ansMergeIntervalsOptimsed));

        int[][] ansMergedIntervalsOp = mergedIntervalsOp(arr);
        System.out.println(Arrays.deepToString(ansMergedIntervalsOp));
    }

    public static int[][] mergeIntervalBruteForce(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        // add all the intervals to the list
        for (int[] in : intervals) {
            list.add(new int[]{in[0], in[1]});
        }

        boolean mergedSomething = true;
        while (mergedSomething) {
            mergedSomething=false;
            for (int i=0; i<list.size(); i++) {
                for (int j=i+1; j<list.size(); j++) {

                    int[] a = list.get(i);
                    int[] b = list.get(j);

                    // overlap condition -> aStart<=bEnd and bstart<=aEnd
                    /*
                    a = [10,12]
                    b = [1,5]

                    a = [1,4]
                    b = [2,3]

                     */
                    if (a[0] <= b[1] && b[0] <= a[1]) {
                        //overlapping condition
                        int newStart = Math.min(a[0], b[0]);
                        int newEnd = Math.max(a[1], b[1]);

                        list.remove(j);
                        list.remove(i);

                        list.add(new int[]{newStart,newEnd});

                        mergedSomething=true;
                        break;
                    }
                }
                if (mergedSomething) break;
            }
        }
        list.sort((x, y) -> Integer.compare(x[0], y[0]));

        return list.toArray(new int[list.size()][2]);
    }

    public static int[][] mergedIntervalsOptimsed(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i=1; i<intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = merged.get(merged.size()-1);

            /*
            (aStart <= bEnd) AND (bStart <= aEnd)

            the moment we sort it guarantees - aStart <= bStart
            and bStart <= bEnd
            so aStart <= bEnd

            therefore - bStart <= aEnd

             */

            //bStart <= aEnd
            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(new int[]{current[0], current[1]});
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }

    public static int[][] mergedIntervalsOp(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // sort on the basis of start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        // iterate over the intervals
        for (int[] curr: intervals) {
            if (result.isEmpty()) {
                result.add(curr);
            } else {
                int[] last = result.get(result.size()-1);

                // overlap exists
                if (curr[0] <= last[1]) {
                    // since the list is sorted, the first index value will always be the minimum value
                    // so no need to change list[0]
                    last[1] = Math.max(last[1], curr[1]);
                } else {
                    result.add(curr);
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
