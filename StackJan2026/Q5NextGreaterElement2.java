package src.StackJan2026;

import java.util.Arrays;
import java.util.Stack;

public class Q5NextGreaterElement2 {
    public static void main(String[] args) {
        //int[] arr = {1,2,1};
        int[] arr = {1,2,3,4,3};

        int[] ansNextGreaterElement2 = nextGreaterElement2(arr);
        System.out.println(Arrays.toString(ansNextGreaterElement2));
    }

    public static int[] nextGreaterElement2(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        Arrays.fill(ans, -1);

        for (int i=2*n-1; i>=0; i--) {
            int idx = i % n;

            while (!stack.isEmpty() && stack.peek() <= arr[idx]) {
                stack.pop();
            }

            if (idx < n) {
                if (stack.isEmpty()) {
                    ans[idx] = -1;
                } else {
                    ans[idx] = stack.peek();
                }
            }

            stack.push(arr[idx]);
        }

        return ans;
    }
}
