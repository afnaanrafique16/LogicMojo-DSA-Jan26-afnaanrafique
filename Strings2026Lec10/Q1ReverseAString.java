package src.Strings2026Lec10;

import java.util.Arrays;

public class Q1ReverseAString {
    public static void main(String[] args) {
        String s = "hello";

        String ansBruteForce = bruteForce(s);
        System.out.println(ansBruteForce);

        String ansStringBuilder = stringBuilderFun(s);
        System.out.println(ansStringBuilder);

        String ansTwoPointer = twoPointerStringReversal(s);
        System.out.println(ansTwoPointer);
    }

    public static String bruteForce(String s) {
        String ans = "";

        for (int i=s.length()-1; i>=0; i--) {
            ans += s.charAt(i);
        }

        return ans;
    }

    public static String stringBuilderFun(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=s.length()-1; i>=0; i--) {
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static String twoPointerStringReversal(String s) {
        int i=0, j=s.length()-1;
        char[] chArr = s.toCharArray();

        while (i < j) {
            char temp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = temp;
            i++;
            j--;
        }

        return new String(chArr);
    }
}
