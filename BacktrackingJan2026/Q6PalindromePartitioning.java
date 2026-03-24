package src.BacktrackingJan2026;

import java.util.ArrayList;
import java.util.List;

public class Q6PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";

        List<List<String>> ansList = palindromePartitioning(s);
        System.out.println(ansList);
    }

    public static List<List<String>> palindromePartitioning(String s) {
        List<List<String>> ansList = new ArrayList<>();
        List<String> current = new ArrayList<>();

        backtrackPalindromePartitioning(s, ansList, current, 0);

        return ansList;
    }

    public static void backtrackPalindromePartitioning(String s, List<List<String>> ansList, List<String> current, int index) {
        if (index == s.length()) {
            ansList.add(new ArrayList<>(current));
        }

        for (int i=index; i<s.length(); i++) {
            String sub = s.substring(index, i+1);

            if (!isPalindrome(sub)) {
                continue;
            }

            current.add(sub);
            backtrackPalindromePartitioning(s, ansList, current, i+1);
            current.remove(current.size()-1);
        }
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
