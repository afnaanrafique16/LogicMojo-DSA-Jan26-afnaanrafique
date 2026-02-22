package src.StackJan2026;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerToRight {
    public static void main(String[] args) {
        int[] arr = {3,8,4,1,2};

        int[] ansNextSmallerToRight = nextSmallerToRight(arr);
        System.out.println(Arrays.toString(ansNextSmallerToRight));
    }

    public static int[] nextSmallerToRight(int[] arr) {
        int[] ans = new int[arr.length];

        // Stack stores possible next greater candidates on the right.
        Stack<Integer> stack = new Stack<>();

        for (int i=arr.length-1; i>=0; i--) {
            while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return ans;
    }
}
