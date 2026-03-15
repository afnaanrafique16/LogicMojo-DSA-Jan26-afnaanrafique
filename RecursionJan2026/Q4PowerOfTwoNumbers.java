package src.RecursionJan2026;

public class Q4PowerOfTwoNumbers {
    public static void main(String[] args) {
        int ansPowerOfTwoNumbers = powerOfTwoNumbers(2, 5);
        System.out.println(ansPowerOfTwoNumbers);
    }

    public static int powerOfTwoNumbers(int a, int b) {
        if (b == 0) {
            return 1;
        }

        int l = a;
        int r = powerOfTwoNumbers(a, b-1);
        int ans = l*r;
        return ans;
    }
}
