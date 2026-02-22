package src.StackJan2026;

import java.util.Arrays;
import java.util.Stack;

public class Q4NextGreaterToLeft {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};

        int[] ansNextGreaterToLeft = nextGreaterToLeft(arr);
        System.out.println(Arrays.toString(ansNextGreaterToLeft));
    }

    public static int[] nextGreaterToLeft(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<arr.length; i++) {
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
