package src.StackJan2026;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterToLEft {
    public static void main(String[] args) {
        int[] arr = {3, 8, 4, 1, 2};

        int[] ansNextGreaterToLeft = nextGreaterToLeft(arr);
        System.out.println(Arrays.toString(ansNextGreaterToLeft));
    }

    public static int[] nextGreaterToLeft(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
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
