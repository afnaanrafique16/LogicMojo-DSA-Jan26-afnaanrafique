package src.MergeIntervalsJan2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q2InsertInterval {
    public static void main(String[] args) {
//        int[][] intervals = {
//                {1, 3},
//                {6, 9}
//        };
//
//        int[] newInterval = {2,5};

        int[][] intervals = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };

        int[] newInterval = {4,8};

        int[][] ansInsertIntervalBruteForce = insertIntervalBruteForce(intervals, newInterval);
        System.out.println(Arrays.deepToString(ansInsertIntervalBruteForce));

        int[][] ansInsertInterval = insertInterval(intervals, newInterval);
        System.out.println(Arrays.deepToString(ansInsertInterval));


        int[][] ansInsertIntervalOp = insertIntervalOp(intervals, newInterval);
        System.out.println(Arrays.deepToString(ansInsertIntervalOp));
    }

    public static int[][] insertIntervalBruteForce(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] all = new int[n + 1][2];

        for (int i = 0; i < n; i++) {
            all[i] = intervals[i];
        }

        all[n] = newInterval;

        // Same as Merge intervals
        Arrays.sort(all, Comparator.comparingInt(a -> a[0])); // => O(nlogn)

        List<int[]> result = new ArrayList<>();

        for (int[] curr: all) {
            if (result.isEmpty()) {
                result.add(curr);
            } else {
                int[] last = result.get(result.size()-1);

                // if overlapping
                if (curr[0] <= last[1]) {
                    last[1] = Math.max(last[1], curr[1]);
                } else {
                    // add the interval into the list
                    result.add(curr);
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    // question says it is already sorted
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();
        int i =0;

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        // end is smaller than newStart
        while (i < intervals.length && intervals[i][1] < newStart) {
            answer.add(intervals[i]);
            i++;
        }

        // interval.start <= newEnd
        while (i < intervals.length && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }

        answer.add(new int[]{newStart, newEnd});

        while (i < intervals.length) {
            answer.add(intervals[i]);
            i++;
        }

        return answer.toArray(new int[answer.size()][]);
    }

    public static int[][] insertIntervalOp(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // all the intervals that have endTime smaller than new Interval's startTime => add them directly into the list
        // 1. Add intervals that come before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge all intervals that overlap with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // 3. Add the merged newInterval
        result.add(newInterval);

        // 4. Add intervals that come after newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
