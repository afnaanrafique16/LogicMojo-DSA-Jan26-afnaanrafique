package src.Arrays2026SlidingWindowLec6;

public class Q1SumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 2, 9, 7, 1};
        int k = 3;

        sumOfAllSubarraysOfSizeKBruteForce(arr, k);
        System.out.println();

        sumOfAllSubarraysOfSizeKOptimised(arr, k);
    }

    public static void sumOfAllSubarraysOfSizeKBruteForce(int[] arr, int k) {
        for (int i=0; i<=arr.length-k; i++) {

            int sum=0;
            // find the sum of all subarray till windowSize
            for (int j=i; j<i+k; j++) {
                sum += arr[j];
            }

            System.out.print(sum + " ");
        }
    }

    public static void sumOfAllSubarraysOfSizeKOptimised(int[] arr, int k) {
        int i=0, j=0;
        int currentWindowSum = 0;

        while (j < arr.length) {
            // initial work
            // expand window
            currentWindowSum += arr[j];

            // main work and shrink
            // till u reach the window size
            if (j-i+1 == k) {
                System.out.print(currentWindowSum + " ");
                // shrinking the window
                currentWindowSum -= arr[i];
                i++;
            }

            j++;
        }
    }
}
