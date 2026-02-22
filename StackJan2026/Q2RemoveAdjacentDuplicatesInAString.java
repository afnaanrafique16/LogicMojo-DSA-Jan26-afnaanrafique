package src.StackJan2026;

import java.util.Stack;

public class Q2RemoveAdjacentDuplicatesInAString {
    public static void main(String[] args) {
        //String s = "abbaca";
        String s = "azxxzy";

        String ansRemoveAdjBruteForce = removeDuplicatesBrute(s);
        System.out.println(ansRemoveAdjBruteForce);

        String ansRemoveAdj = removeAdj(s);
        System.out.println(ansRemoveAdj);
    }


    public static String removeDuplicatesBrute(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean changed = true;

        while (changed) {
            changed = false;

            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);   // remove both duplicates
                    changed = true;
                    break;  // restart scanning from beginning
                }
            }
        }

        return sb.toString();
    }

    public static String removeAdj(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            // NOTE -> WHENEVER U USE AN OBJECT MAKE IT NPE SAFE
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        // Stack -> [c,a] => "ca"
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch: stack) {
            stringBuilder.append(ch);
        }

        return stringBuilder.toString();
    }
}
