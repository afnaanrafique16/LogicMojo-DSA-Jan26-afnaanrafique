package src.StackJan2026;

import java.util.Stack;

public class Q1ValidParenthesis {
    public static void main(String[] args) {
        //String s = "()[]{}";
        String s = "([)]";

        boolean ansValidParenthesisBruteForce = validParenthesisBruteForce(s);
        System.out.println(ansValidParenthesisBruteForce);
        
        boolean ansValidParenthesisStack = validParenthesisStack(s);
        System.out.println(ansValidParenthesisStack);
    }
    
    public static boolean validParenthesisStack(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            // push any open bracket onto the stack
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static boolean validParenthesisBruteForce(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s=s.replace("()", "");
            s=s.replace("[]", "");
            s=s.replace("{}", "");
        }

        return s.isEmpty();
    }
}
