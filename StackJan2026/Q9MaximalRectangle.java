package src.StackJan2026;

import java.util.Stack;

public class Q9MaximalRectangle {
    public static void main(String[] args) {
//        int[][] arr = {
//                {0, 1, 1, 0},
//                {1, 1, 1, 1},
//                {1, 1, 1, 1},
//                {1, 1, 0, 0}
//        };

        int[][] arr = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0},
        };

        int ansMaximalRectangle = maximalRectangle(arr);
        System.out.println(ansMaximalRectangle);
    }

    public static int maximalRectangle(int[][] arr) {
        // histogram created row by row from top
        int[] hist = new int[arr[0].length];

        // adding first row in the histogram
        for (int j=0; j<arr[0].length; j++) {
            hist[j] = arr[0][j];
        }
        int maxArea = maximumAreaOfHistogram(hist);

        for (int i=1; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    hist[j] = 0;
                } else {
                    hist[j] = hist[j] + arr[i][j];
                }
            }

            int area = maximumAreaOfHistogram(hist);
            // maxArea is the running max of all the histograms
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // MAX AREA OF HISTOGRAM CODE
    public static int maximumAreaOfHistogram(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] indexOfNearestSmallestToLeft = new int[arr.length];
        int[] indexOfNearestSmallestToRight = new int[arr.length];
        int ans = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                indexOfNearestSmallestToLeft[i] = -1;
            } else {
                indexOfNearestSmallestToLeft[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        //System.out.println(Arrays.toString(indexOfNearestSmallestToLeft));

        for (int i=arr.length-1; i>=0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                indexOfNearestSmallestToRight[i] = arr.length;
            } else {
                indexOfNearestSmallestToRight[i] = stack.peek();
            }

            stack.push(i);
        }

        //System.out.println(Arrays.toString(indexOfNearestSmallestToRight));

        for (int i=0; i<arr.length; i++) {
            int diff = ((indexOfNearestSmallestToRight[i] - indexOfNearestSmallestToLeft[i]) - 1) * arr[i];
            ans = Math.max(ans, diff);
        }

        return ans;
    }
}
