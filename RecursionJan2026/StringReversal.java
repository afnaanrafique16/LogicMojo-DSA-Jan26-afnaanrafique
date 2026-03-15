package src.RecursionJan2026;

public class StringReversal {
    public static void main(String[] args) {
        String s = "hello";

        String ansStringReversal = stringReversal(s);
        System.out.println(ansStringReversal);

        String ansStringReversalStringBuilder = stringReversalStringBuilder(s);
        System.out.println(ansStringReversalStringBuilder);

        String ansStringReversalStringBuilderFromBack = stringReversalStringBuilderFromBack(s);
        System.out.println(ansStringReversalStringBuilderFromBack);
    }

    public static String stringReversalStringBuilderFromBack(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        funRec(s, stringBuilder, s.length()-1);
        return stringBuilder.toString();
    }

    public static void funRec(String s, StringBuilder stringBuilder, int index) {
        if (index < 0) {
            return;
        }

        char l = s.charAt(index);
        stringBuilder.append(l);
        funRec(s, stringBuilder, index-1);
    }

    public static String stringReversalStringBuilder(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        recursiveHelper(s, stringBuilder, 0);
        return stringBuilder.toString();
    }

    public static void recursiveHelper(String s, StringBuilder stringBuilder, int index) {
        if (index == s.length()) {
            return;
        }

        recursiveHelper(s, stringBuilder, index+1);
        stringBuilder.append(s.charAt(index));
    }

    public static String stringReversal(String s) {
        if (s.length() == 0) {
            return "";
        }

        String l = stringReversal(s.substring(1));
        char r = s.charAt(0);
        String ans = l+r;
        return ans;
    }
}
