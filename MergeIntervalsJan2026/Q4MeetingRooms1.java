package src.MergeIntervalsJan2026;

import java.util.Arrays;
import java.util.Comparator;

/*
You are given intervals representing meeting timings:

intervals = [[0,30], [5,10], [15,20]]

Each interval = [start, end]

👉 Question:

Can a person attend all meetings?
 */
public class Q4MeetingRooms1 {
    public static void main(String[] args) {
//        int[][] intervals = {
//                {0, 30},
//                {5, 10},
//                {15, 20}
//        };

        int[][] intervals = {
                {0, 3},
                {5, 10},
                {15, 20}
        };

        boolean ansMeetingRooms1BruteForce = meetingRooms1BruteForce(intervals);
        System.out.println(ansMeetingRooms1BruteForce);

        boolean ansMeetingRoom1Optimised = meetingRoomsOptimised(intervals);
        System.out.println(ansMeetingRoom1Optimised);
    }

    /*
    a = [8,10]
    b = [1,3]
    */

    /*

    Two intervals do NOT overlap only in 2 cases:

1) a completely before b → a ends before b starts
   a[1] < b[0]

2) b completely before a → b ends before a starts
   b[1] < a[0]

   So overlap means:
    NOT (a[1] < b[0] OR b[1] < a[0])

    Apply De Morgan’s Law:

    (a[1] >= b[0]) AND (b[1] >= a[0])

Rewriting:
    b[0] <= a[1] && a[0] <= b[1]
     */

    public static boolean meetingRooms1BruteForce(int[][] intervals) {
        int n = intervals.length;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int[] prev = intervals[i];
                int[] curr = intervals[j];

                // no <= because we can attend both if meetings hv timing {1,3}, {3,5}
                /*
                overlapping condition

                NOT (not overlapping)
                 */
                if (curr[0] < prev[1] && prev[0] < curr[1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean meetingRoomsOptimised(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        // sort on the basis of start times of the interval
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // iterate over the interval and compute
        for (int i=1; i< intervals.length; i++) {
            int[] prev = intervals[i-1];
            int[] curr = intervals[i];

            // if currentStart < previousEnd => Overlap exists
            if (curr[0] < prev[1]) {
                return false;
            }
        }

        // After iteration => No overlap
        return true;
    }
}
