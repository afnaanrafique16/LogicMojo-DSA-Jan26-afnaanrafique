package src.Arrays2026TwoPointerLec5;

public class Q6ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int ansContainerWithMostWaterBruteForce = containerWithMostWaterBruteForce(arr);
        System.out.println(ansContainerWithMostWaterBruteForce);

        int ansContainerWithMostWaterOptimsed = containerWithMostWaterOptimsed(arr);
        System.out.println(ansContainerWithMostWaterOptimsed);
    }

    public static int containerWithMostWaterBruteForce(int[] arr) {
        int maxArea = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                int length = Math.min(arr[i], arr[j]);
                int breadth = j-i;

                int area = length * breadth;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static int containerWithMostWaterOptimsed(int[] arr) {
        // Maximises area => maximising lenght, maximising breadth
        // take two pointers at the extreme to maximise breadth
        int i=0, j=arr.length-1;
        int maxArea = Integer.MIN_VALUE;

        while (i < j) {
            int length = Math.min(arr[i], arr[j]);
            int breadth = j-i;

            int area = length * breadth;
            maxArea = Math.max(maxArea, area);

            if (arr[i] < arr[j]) {
                // we need to find maximum area so if the ht is small we will move that pointer
                // in a hope we get a larger value in future so that area is maximised
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
