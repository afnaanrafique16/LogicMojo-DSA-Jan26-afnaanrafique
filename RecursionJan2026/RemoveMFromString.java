package src.RecursionJan2026;

public class RemoveMFromString {
    public static void main(String[] args) {
        //String s = "ambmcm";
        String s = "pqrmmm";

        String ansRemoveMFromString = removeMFromString(s, 0);
        System.out.println(ansRemoveMFromString);

        String ansRemoveMFromStringBuilder = removeMFromStringBuilder(s);
        System.out.println(ansRemoveMFromStringBuilder);
    }

    public static String removeMFromStringBuilder(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        removeMFromStringRec(s, 0, stringBuilder);

        return stringBuilder.toString();
    }

    public static void removeMFromStringRec(String s, int index, StringBuilder stringBuilder) {
        if (index == s.length()) {
            return;
        }

        char ch = s.charAt(index);
        if (ch != 'm') {
            stringBuilder.append(ch);
        }

        removeMFromStringRec(s, index+1, stringBuilder);
    }

    public static String removeMFromString(String s, int index) {
        if (s.length() == index) {
            return "";
        }

        char l = s.charAt(index);
        String r = removeMFromString(s, index+1);
        if (l == 'm') {
            return r;
        }
        String ans = l+r;

        return ans;
    }
}
