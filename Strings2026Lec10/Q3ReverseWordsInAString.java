package src.Strings2026Lec10;

public class Q3ReverseWordsInAString {
    public static void main(String[] args) {
        //String s = "  hello world  ";
        String s = "hello world";

        String ansReverseWordsInAString = reverseWordsInAString(s);
        System.out.println(ansReverseWordsInAString);
    }

    public static String reverseWordsInAString(String  s) {
        int i=s.length()-1; // pointer at the end of the string
        StringBuilder stringBuilder = new StringBuilder();

        while (i>=0) {
            // to ignore the spaces at the end
            /*

            j=> end of string
            i=> one space before start of string
                       j
            _______hello world____
          i


            sb = world hello

                j
            hello world
           i

            world hello
                _______          i
             */
            while (i>=0 && s.charAt(i) == ' ') {
                i--;
            }

            // "  " => empty string
            if (i < 0) {
                break;
            }

            // to mark the end of the string
            int j = i;
            while (i>=0 && s.charAt(i) != ' ') {
                i--;
            }

            stringBuilder.append(s.substring(i+1, j+1));

            stringBuilder.append(" ");
        }

        return stringBuilder.toString().trim();
    }
}
