package src.Strings2026Lec10;

public class Q2PalindromeChecking {
    public static void main(String[] args) {
        //String s = "naman";
        String s = "abcf";

        boolean ansIsPalindrome = isPalindrome(s);
        System.out.println(ansIsPalindrome);
    }

    public static boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;

        while (i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

}
