package src.RecursionJan2026;

public class MaxOfArray {
    public static void main(String[] args) {
        //int[] arr = {3, 1, 5, 2};
        int[] arr = {1, 2, 3, 4};

        int ansMaxOfArrayRec = maxOfArrayRec(arr, 0);
        System.out.println(ansMaxOfArrayRec);
    }

    public static int maxOfArrayRec(int[] arr, int index) {
        if (index == arr.length) {
            return Integer.MIN_VALUE;
        }

        // grep the element pointed by index
        int l = arr[index];

        // find the max from the remaining array => Relying on that recursion will give us the correct ans.
        int r = maxOfArrayRec(arr, index+1);
        int ans = Math.max(l, r);
        return ans;
    }
}
