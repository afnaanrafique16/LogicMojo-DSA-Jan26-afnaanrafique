package src.StackJan2026;

import java.util.Stack;

public class Q10MinElementInStack {
    public static Stack<Integer> mainStack = new Stack<>();
    public static Stack<Integer> minElementStack = new Stack<>();

    public static void main(String[] args) {
        push(3);
        push(2);
        push(5);
        push(4);
        push(1);
        push(0);

        System.out.println(mainStack);
        System.out.println(minElementStack);

        pop();
        int ansGetMin = getMin();
        System.out.println(ansGetMin);

        pop();
        ansGetMin = getMin();
        System.out.println(ansGetMin);

        pop();
        ansGetMin = getMin();
        System.out.println(ansGetMin);

        pop();
        ansGetMin = getMin();
        System.out.println(ansGetMin);
    }

    public static int getMin() {
        if (mainStack.isEmpty() || minElementStack.isEmpty()) {
            return -1;
        }

        // get the first value from minElementStack
        int minElement = minElementStack.peek();

        return minElement;
    }

    public static int pop() {
        if (mainStack.isEmpty()) {
            return -1;
        }
        int top = mainStack.peek();

        if (mainStack.peek() == minElementStack.peek()) {
            minElementStack.pop();
        }

        mainStack.pop();
        return top;
    }

    public static void push(int num) {
        mainStack.push(num);
        if (minElementStack.isEmpty()) {
            minElementStack.push(num);
        } else {
            if (num <= minElementStack.peek()) {
                // pushing only the min element
                minElementStack.push(num);
            }
        }
    }
}
