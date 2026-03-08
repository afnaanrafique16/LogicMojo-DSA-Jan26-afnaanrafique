package src.HashMap2026Lec15;

import java.util.HashMap;

public class Q6LengthOfMinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

//        String s = "TOTMTAPTAT";
//        String t = "TTA";

        int ansMinimumWindowSubstring = minimumWindowSubstring(s, t);
        System.out.println(ansMinimumWindowSubstring);
    }

    public static int minimumWindowSubstring(String s, String t) {
        // to store t's characters vs count
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i=0; i<t.length(); i++) {
            char tChar = t.charAt(i);
            tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
        }

        int count = tMap.size(); // count indicates the characters which u need to get it fulfilled from s.
        int i=0, j=0, minLen = Integer.MAX_VALUE;

        while (j < s.length()) {
            char sChar = s.charAt(j);

            // trying to find the characters of s in tMap.
            if (tMap.containsKey(sChar)) {
                // the moment we see a character, decrement the value => if 2 are required, 1 already seen => 2-1 = 1 required more
                tMap.put(sChar, tMap.get(sChar) - 1);

                if (tMap.get(sChar) == 0) {
                    count--;
                }
            }

            // a window is valid the moment count becomes 0.
            while (count == 0) {
                minLen = Math.min(minLen, j-i+1);

                char iChar = s.charAt(i);
                if (tMap.containsKey(iChar)) {
                    tMap.put(iChar, tMap.getOrDefault(iChar, 0) +1);

                    if (tMap.get(iChar) == 1) {
                        count++;
                    }
                }

                i++;
            }

            j++;
        }
        return minLen;
    }
}
