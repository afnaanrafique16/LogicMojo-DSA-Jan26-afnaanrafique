package src.StackJan2026;

import java.util.Stack;

public class Q6MaximumAreaOfHistogram {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        //int[] arr = {2, 1, 5, 6, 2, 3};
        //int[] arr = {0, 1, 1, 0};

        int ansMaximumAreaOfHistogram = maximumAreaOfHistogram(arr);
        System.out.println(ansMaximumAreaOfHistogram);
    }

    public static int maximumAreaOfHistogram(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nsl = new int[arr.length];
        int[] nsr = new int[arr.length];
        int maxArea = Integer.MIN_VALUE;

        // calculating index of nearest smallest to the left
        for (int i=0; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek();
            }

            stack.push(i);
        }

        // to calculate the neaterSmallestToTheRight, I am using the same stack
        stack.clear();

        //System.out.println(Arrays.toString(nsl));

        // calculate index of nearest smallest to the right
        for (int i=arr.length-1; i>=0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = stack.peek();
            }

            stack.push(i);
        }

        //System.out.println(Arrays.toString(nsr));

        // calculate width and find the max area
        for (int i=0; i<arr.length; i++) {
            /*
            width = nsr[i]-nsl[i]-1
            ht = arr[i]
             */
            int area = ((nsr[i] - nsl[i]) - 1) * arr[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
