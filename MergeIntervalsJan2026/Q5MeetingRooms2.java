package src.MergeIntervalsJan2026;

import java.util.Arrays;

public class Q5MeetingRooms2 {
    public static void main(String[] args) {
        int[][] intervals = {
                {0, 30},
                {5, 10},
                {15, 20}
        };

        int ansMeetingRooms2BruteForce = meetingRooms2BruteForce(intervals);
        System.out.println(ansMeetingRooms2BruteForce);

        int ansMeetingRooms2Optimised = meetingRooms2Optimised(intervals);
        System.out.println(ansMeetingRooms2Optimised);
    }

    public static int meetingRooms2BruteForce(int[][] intervals) {
        int minTime = Integer.MAX_VALUE;
        int maxTime = Integer.MIN_VALUE;

        // find the smallest start time and largest end time
        for (int[] interval : intervals) {
            minTime = Math.min(minTime, interval[0]);
            maxTime = Math.max(maxTime, interval[1]);
        }

        int maxRooms = 0;

        // at each tome from mintime to maxtime we are going to see how many meetings are going and then
        // find the max out of this

        for (int t=minTime; t<=maxTime; t++) {
            int count = 0;

            for (int[] interval: intervals) {
                if (interval[0] <= t && t < interval[1]) {
                    count++;
                }
            }

            maxRooms = Math.max(maxRooms, count);
        }

        return maxRooms;
    }

    public static int meetingRooms2Optimised(int[][] intervals) {
        int n = intervals.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i=0, j=0;
        int rooms = 0, maxRooms = 0;

        while (i < n) {
            if (start[i] < end[j]) {
                rooms++;
                i++;
                maxRooms = Math.max(maxRooms, rooms);
            } else {
                rooms--;
                j++;
            }
        }

        return maxRooms;
    }
}
