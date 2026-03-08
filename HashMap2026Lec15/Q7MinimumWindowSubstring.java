package src.HashMap2026Lec15;

import java.util.HashMap;

public class Q7MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindowSubstring(s, t);
        System.out.println(result);
    }

    public static String minWindowSubstring(String s, String t) {
        HashMap<Character, Integer> targetMap = new HashMap<>();


        // Initialize the targetMap with character frequencies of the target string
        /*
        Target map creation
        A -> 1  (1 A required)
        B -> 1  (1 B required)
        C -> 1  (1 C required)
         */
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0;
        int count = targetMap.size();
        int minLen = Integer.MAX_VALUE;
        int windowStartAns = 0;

        while (j < s.length()) {
            char jChar = s.charAt(j);

            // Update the targetMap and count for the j character
            if (targetMap.containsKey(jChar)) {
                targetMap.put(jChar, targetMap.get(jChar) - 1);
                if (targetMap.get(jChar) == 0) {
                    count--;
                }
            }

            /*
            // Valid window -> count == 0
                Calculate minLength
                    minLength = Math.min(minLength, j-i+1);

                Slide the window using i

             */
            // Check if all characters in the target string are matched
            while (count == 0) {
                // shrink the window and check if a better ans can be obtained.
                // Update the minimum window if the current window is smaller
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    windowStartAns = i;
                }

                // Contract the window from the i
                char iChar = s.charAt(i);
                if (targetMap.containsKey(iChar)) {
                    targetMap.put(iChar, targetMap.get(iChar) + 1);
                    if (targetMap.get(iChar) > 0) {
                        count++;
                    }
                }

                i++;
            }

            // Expand the window to the j
            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(windowStartAns, windowStartAns + minLen);
    }
}
