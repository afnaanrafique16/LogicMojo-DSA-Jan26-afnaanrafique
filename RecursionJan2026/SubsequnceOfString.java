package src.RecursionJan2026;

public class SubsequnceOfString {
    public static void main(String[] args) {
        String s = "abc";

        subsequence(s, 0, "");
    }

    public static void subsequence(String s, int index, String newString) {
        if (index == s.length()) {
            System.out.print(newString + " ");
            return;
        }

        char curr = s.charAt(index);

        // to include
        subsequence(s, index+1, newString+curr);

        // to exclude
        subsequence(s, index+1, newString);
    }
}
