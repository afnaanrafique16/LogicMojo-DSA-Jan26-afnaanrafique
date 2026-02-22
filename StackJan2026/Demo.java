package src.StackJan2026;

import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack);

    }
}
