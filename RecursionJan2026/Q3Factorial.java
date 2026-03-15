package src.RecursionJan2026;

public class Q3Factorial {
    public static void main(String[] args) {
        int ansFactRec = factRec(5);
        System.out.println(ansFactRec);
    }

    public static int factRec(int n) {
        if (n == 0) {
            return 1;
        }

        int l = n;
        int r = factRec(n-1);
        int ans = l*r;
        return ans;
    }
}
