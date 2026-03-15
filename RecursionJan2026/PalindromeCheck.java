package src.RecursionJan2026;

public class PalindromeCheck {
    public static void main(String[] args) {
        //String s = "naman";
        String s = "abcd";

        boolean ansPalindromeCheck = isPalindrome(s, 0, s.length()-1);
        System.out.println(ansPalindromeCheck);
    }

    public static boolean isPalindrome(String s, int i, int j) {
        if (i == j) {
            return true;
        }

        char first = s.charAt(i);
        char last = s.charAt(j);

        if (first != last) {
            return false;
        }

        return isPalindrome(s, i+1, j-1);
    }
}
