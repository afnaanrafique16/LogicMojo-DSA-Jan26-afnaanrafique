package src.RecursionJan2026;

public class Q2SumOfFirstNNaturalNumbers {
    public static void main(String[] args) {
        int ansSum = sum(5);
        System.out.println(ansSum);
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }

        /*
        return n + A(n-1)
         */
        int l = n;
        int r = sum(n-1);
        int ans = l+r;
        return ans;
    }
}
