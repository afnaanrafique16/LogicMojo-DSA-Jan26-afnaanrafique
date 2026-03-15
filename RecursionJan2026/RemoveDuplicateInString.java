package src.RecursionJan2026;

public class RemoveDuplicateInString {
    public static void main(String[] args) {
        String s = "abbccda";

        boolean[] seen = new boolean[26];
        String ansRemoveDuplicateInAString = removeDuplicateInAString(s, 0, seen);
        System.out.println(ansRemoveDuplicateInAString);

        boolean[] newSeen = new boolean[26];
        StringBuilder stringBuilder = new StringBuilder();
        removeDuplicateStringBuilder(s, 0, newSeen, stringBuilder);
        System.out.println(stringBuilder);
    }

    public static String removeDuplicateInAString(String s, int index, boolean[] seen) {
        if (index == s.length()) {
            return "";
        }

        char l = s.charAt(index);

        if (seen[l-'a']) {
            String r = removeDuplicateInAString(s, index+1, seen);
            return r;
        }

        seen[l-'a'] = true;
        String r = removeDuplicateInAString(s, index+1, seen);
        String ans = l+r;
        return ans;
    }

    public static void removeDuplicateStringBuilder(String s, int index, boolean[] seen, StringBuilder stringBuilder) {
        if (index == s.length()) {
            return;
        }

        char l = s.charAt(index);

        if (!seen[l - 'a']) {
            seen[l-'a'] = true;
            stringBuilder.append(l);
        }

        removeDuplicateStringBuilder(s, index+1, seen, stringBuilder);
    }
}
