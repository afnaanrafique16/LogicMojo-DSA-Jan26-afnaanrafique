package src.QueueJan2026;

import java.util.LinkedList;
import java.util.Queue;

public class Q2FirstNonRepeatingCharacterInAStream {
    public static void main(String[] args) {
        //String input = "aabc";
        String input = "aabcbdce";

        firstNonRepeatingCharacterinAStream(input);
    }

    public static void firstNonRepeatingCharacterinAStream(String input) {
        Queue<Character> queue = new LinkedList<>();
        // freq array of size 26, because it contains only lowercase letters.
        int[] freq = new int[26];

        for (char ch: input.toCharArray()) {
            // update the frequency of each character
            freq[ch - 'a'] += 1;

            // add it to the queue
            queue.add(ch);

            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(queue.peek() + " ");
            }
        }
    }
}
