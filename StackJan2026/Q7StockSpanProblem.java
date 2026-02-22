package src.StackJan2026;

import java.util.Arrays;
import java.util.Stack;

public class Q7StockSpanProblem {
    public static void main(String[] args) {
        //int[] arr = {1, 3, 2, 4};
        int[] arr = {100, 80, 60, 70, 60, 75, 85};

        int[] ansStockSpan = stockSpan(arr);
        System.out.println(Arrays.toString(ansStockSpan));
    }

    public static int[] stockSpan(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = i+1;
            } else {
                ans[i] = i - stack.peek();
            }

            // push the INDEX onto the stack
            stack.push(i);
        }


        return ans;
    }
}
