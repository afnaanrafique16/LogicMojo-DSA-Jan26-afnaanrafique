package src.RecursionJan2026;

public class PlaceTiles {
    public static void main(String[] args) {
        int n=4, m=2;

        int ansPlaceTiles = placeTiles(n, m);
        System.out.println(ansPlaceTiles);
    }

    public static int placeTiles(int n, int m) {
        if (n == 1 && m == 1) {
            return 1;
        }

        if (n < m) {
            return 1;
        }

        if (n == m) {
            return 2;
        }

        int horizontal = placeTiles(n-1, m);
        int vertical = placeTiles(n-m, m);
        int ans = horizontal+vertical;

        return ans;
    }

}
