package src.Strings2026Lec10;

import java.util.Arrays;

public class Q5LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABABBA";

        int k=2;

        int ansLongestSubstringWithCharacterReplacement = longestSubstringWithCharacterReplacement(s, k);
        System.out.println(ansLongestSubstringWithCharacterReplacement);

    }

    public static int longestSubstringWithCharacterReplacement(String s, int k) {
        int i=0, j=0, maxLength = 0;

        //freq Array
        int[] sArr = new int[26];

        while (j < s.length()) {
            sArr[s.charAt(j) - 'A'] += 1;

            // windowLength - max achieved
            while ((j-i+1) - Arrays.stream(sArr).max().getAsInt() > k) {
                // shrink the window as the window is invalid for calculation
                sArr[s.charAt(i) - 'A'] -= 1;
                i++;
            }

            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }

        return maxLength;
    }
}
