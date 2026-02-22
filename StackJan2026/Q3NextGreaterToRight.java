package src.StackJan2026;

import java.util.Arrays;
import java.util.Stack;

public class Q3NextGreaterToRight {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};

        int[] ansNextGreaterToRigth = nextGreaterToRight(arr);
        System.out.println(Arrays.toString(ansNextGreaterToRigth));
    }

    public static int[] nextGreaterToRight(int[] arr) {
        int[] ans = new int[arr.length];

        // Stack stores possible next greater candidates on the right.
        Stack<Integer> stack = new Stack<>();

        for (int i=arr.length-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
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
