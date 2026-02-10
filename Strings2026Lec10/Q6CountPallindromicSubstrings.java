package src.Strings2026Lec10;

public class Q6CountPallindromicSubstrings {
    public static void main(String[] args) {
        //String s = "aaa";
        String s = "abc";
        //String s = "aaab";

        int ansCountBruteForce = countBruteForce(s);
        System.out.println(ansCountBruteForce);

        int ansCountOptimised = countOptimised(s);
        System.out.println(ansCountOptimised);
    }

    public static int countBruteForce(String s) {
        // find all substrings that are palindrome
        // O(n^3)
        int count=0;
        for (int i=0; i<s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static int countOptimised(String  s) {
        int count =0;
        for (int center = 0; center<s.length(); center++) {

            // odd
            count += expandCenter(s, center, center);

            // even
            count += expandCenter(s, center, center+1);
        }

        return count;
    }

    // check for palindrome and update the count
    public static int expandCenter(String s, int l, int r) {
        int count=0;
        while (l >=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }

        return count;
    }
}
