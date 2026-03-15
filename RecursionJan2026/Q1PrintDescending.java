package src.RecursionJan2026;

public class Q1PrintDescending
{
    public static void main(String[] args) {
        printDescRec(5);
        System.out.println();

        printAscRec(5);
        System.out.println();
    }

    public static void printDescRec(int n) {
        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        printDescRec(n-1);
    }

    public static void printAscRec(int n) {
        if (n == 0) {
            return;
        }

        printAscRec(n-1);
        System.out.print(n + " ");
    }
}
