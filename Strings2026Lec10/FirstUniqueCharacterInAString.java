package src.Strings2026Lec10;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String s = "loveleetcode";
        //String s = "leetcode";


        int ansFirstUniqueCharacterBruteForce = firstUniqueCharacterBruteForce(s);
        System.out.println(ansFirstUniqueCharacterBruteForce);

        int ansFirstUniqueCharacterFrequencyDistribution = fucFreqDist(s);
        System.out.println(ansFirstUniqueCharacterFrequencyDistribution);
    }

    public static int firstUniqueCharacterBruteForce(String s) {
        for (int i=0; i<s.length(); i++) {
            boolean found = false;
            for (int j=i+1; j<s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return i;
            }

        }

        return -1;
    }

    public static int fucFreqDist(String s) {
        int[] freqArr = new int[26];

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            freqArr[ch - 'a'] += 1;
        }

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (freqArr[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
