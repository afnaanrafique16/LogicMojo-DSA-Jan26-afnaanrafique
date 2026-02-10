package src.Strings2026Lec10;

public class Q4LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "bcadaadefg";

        int ansLongestSubstringWithoutRepeatingCharacters = longestSubstringWithoutRepeatingCharacters(s);
        System.out.println(ansLongestSubstringWithoutRepeatingCharacters);
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int i=0, j=0;
        int[] freqArr = new int[26]; // to hold the frequencies/count of each character in a string
        int maxLength = 0;

        while (j < s.length()) {
            freqArr[s.charAt(j) - 'a'] += 1;

            // till the time character at window is > 1 => duplicate and hence invalid window
            while (freqArr[s.charAt(j) - 'a'] > 1) {
                // shrink the window
                freqArr[s.charAt(i) - 'a'] -= 1;
                i++;
            }

            maxLength = Math.max(maxLength, j-i+1);
            j++;

        }

        return maxLength;
    }
}
