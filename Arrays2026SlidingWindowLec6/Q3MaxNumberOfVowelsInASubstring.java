package src.Arrays2026SlidingWindowLec6;

public class Q3MaxNumberOfVowelsInASubstring {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;

        int ansMaxVowelsBruteForce = maxVowelsBruteForce(s, k);
        System.out.println(ansMaxVowelsBruteForce);

        int ansMaxVowelsSlidingWindow = maxVowelsSlidingWindow(s, k);
        System.out.println(ansMaxVowelsSlidingWindow);
    }

    public static int maxVowelsBruteForce(String s, int k) {
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<=s.length()-k; i++) {
            int currentWindowSum=0;
            // check for all subsequent subarrays
            for (int j=i; j<i+k; j++) {
                char ch = s.charAt(j);
                if (isVowel(ch)) {
                    currentWindowSum++;
                }
            }
            maxSum = Math.max(maxSum, currentWindowSum);
        }

        return maxSum;
    }

    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    }

    public static int maxVowelsSlidingWindow(String s, int k) {
        int i=0, j=0;
        int maxValue = Integer.MIN_VALUE;
        int currentWindowSum=0;

        while (j < s.length()) {
            char ch = s.charAt(j);
            if (isVowel(ch)) {
                currentWindowSum+=1;
            }

            if (j-i+1 == k) {
                maxValue = Math.max(maxValue, currentWindowSum);

                char firstChar = s.charAt(i);
                if (isVowel(firstChar)) {
                    currentWindowSum-=1;
                }
                i++;
            }

            j++;
        }

        return maxValue;
    }
}
