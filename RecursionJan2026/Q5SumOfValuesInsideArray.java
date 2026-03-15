package src.RecursionJan2026;

public class Q5SumOfValuesInsideArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int ansSumOfValuesInsideArray = sumOfValuesInsideArray(arr, 0);
        System.out.println(ansSumOfValuesInsideArray);
    }

    public static int sumOfValuesInsideArray(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }

        int l = arr[index];
        int r = sumOfValuesInsideArray(arr, index+1);
        int ans = l+r;
        return ans;
    }
}
