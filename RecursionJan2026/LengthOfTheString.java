package src.RecursionJan2026;

public class LengthOfTheString {
    public static void main(String[] args) {
        String s = "hello";

        int ansLengthOfString = lengthOfString(s);
        System.out.println(ansLengthOfString);

        int ansLengthOptimised = lengthOptimised(s, 0);
        System.out.println(ansLengthOptimised);
    }

    // O(n^2)
    public static int lengthOfString(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int l = 1;
        int r = lengthOfString(s.substring(1));
        int ans = l+r;
        return ans;
    }

    public static int lengthOptimised(String s, int index) {
        if (index == s.length()) {
            return 0;
        }

        int l = 1;
        int r = lengthOptimised(s, index+1);
        int ans = l+r;
        return ans;
    }
}
