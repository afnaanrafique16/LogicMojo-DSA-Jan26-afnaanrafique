package src.RecursionJan2026;

public class MoveAllXToEnd {
    public static void main(String[] args) {
        String str = "axbcxxd";

        String ansRec = recMoveAllXToEnd(str);
        System.out.println(ansRec);

        String ansMoveAllXToEndStringBuilder = moveAllXtoEndStringBuilder(str);
        System.out.println(ansMoveAllXToEndStringBuilder);
    }

    public static String moveAllXtoEndStringBuilder(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        helper(s, stringBuilder, 0);
        return stringBuilder.toString();
    }

    public static void helper(String s, StringBuilder stringBuilder, int index) {
        if (index == s.length()) {
            return;
        }

        char l = s.charAt(index);
        if (l != 'x') {
            stringBuilder.append(l);
        }

        helper(s, stringBuilder, index+1);
        if (l == 'x') {
            stringBuilder.append(l);
        }
    }

    public static String recMoveAllXToEnd(String s) {
        if (s.length() == 0) {
            return "";
        }

        char l = s.charAt(0);
        String r = recMoveAllXToEnd(s.substring(1));

        if (l == 'x') {
            String ans = r+l;
            return ans;
        } else {
            String ans = l+r;
            return ans;
        }
    }
}
