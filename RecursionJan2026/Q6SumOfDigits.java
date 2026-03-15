package src.RecursionJan2026;

public class Q6SumOfDigits {
    public static void main(String[] args) {
        int ansSumOfDigits = sumOfDigits(1234);
        System.out.println(ansSumOfDigits);
    }

    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }

        int l = n%10;
        int r = sumOfDigits(n/10);
        int ans = l + r;
        return ans;
    }
}
