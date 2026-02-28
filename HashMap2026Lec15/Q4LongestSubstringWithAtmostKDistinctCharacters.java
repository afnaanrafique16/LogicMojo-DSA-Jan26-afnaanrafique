package src.HashMap2026Lec15;

import java.util.HashMap;

public class Q4LongestSubstringWithAtmostKDistinctCharacters {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        int ansLongestSubstringWithAtmostKDistinctCharacter = longestSubstringWithAtmostKDistinctCharacters(s, k);
        System.out.println(ansLongestSubstringWithAtmostKDistinctCharacter);
    }

    public static int longestSubstringWithAtmostKDistinctCharacters(String s, int k) {
        int i=0, j=0;
        int maxLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        while (j < s.length()) {
            char windowEndChar = s.charAt(j);
            hashMap.put(windowEndChar, hashMap.getOrDefault(windowEndChar, 0) + 1);

            // the window should be shrunk the moment hashMap's size breaches the k value
            while (hashMap.size() > k) {
                char windowStartChar = s.charAt(i);
                int count = hashMap.get(windowStartChar) - 1;

                if (count >= 1) {
                    hashMap.put(windowStartChar, count);
                } else {
                    hashMap.remove(windowStartChar);
                }

                i++;
            }

            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }

        return maxLength;
    }
}
