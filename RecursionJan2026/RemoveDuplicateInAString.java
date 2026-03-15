package src.RecursionJan2026;

public class RemoveDuplicateInAString {
    public static void main(String[] args) {
        String s = "abcdaaabcd";

        boolean[] seen = new boolean[26];
        String ansRemoveDuplicate = removeDuplicate(s, 0, seen, "");
        System.out.println(ansRemoveDuplicate);

        String ansRemoveDuplicateStringBuilder = removeDuplicateStringBuilder(s);
        System.out.println(ansRemoveDuplicateStringBuilder);
    }

    public static String removeDuplicateStringBuilder(String s) {
        boolean[] seen = new boolean[26];
        StringBuilder stringBuilder = new StringBuilder();
        helper(s, 0, stringBuilder, seen);
        return stringBuilder.toString();
    }

    public static void helper(String s, int index, StringBuilder stringBuilder, boolean[] seen) {
        if (index == s.length()) {
            return;
        }

        char l = s.charAt(index);
        if (!seen[l-'a']) {
            seen[l-'a'] = true;
            stringBuilder.append(l);
        }

        helper(s, index+1, stringBuilder, seen);
    }

    public static String removeDuplicate(String s, int index, boolean[] seen, String newString) {
        if (index == s.length()) {
            return newString;
        }

        char l = s.charAt(index);
        if (!seen[l-'a']) {
            seen[l-'a'] = true;
            newString+=l;
        }
        String r = removeDuplicate(s, index+1, seen, newString);

        return r;
    }


}
