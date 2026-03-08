package src.HashSetJan2026;

import java.util.*;

public class Q5FourSum {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target=0;

        List<List<Integer>> ansListBruteForce = listBruteForce(arr, target);
        System.out.println(ansListBruteForce);

        List<List<Integer>> ansListOptimised = listOptimised(arr, target);
        System.out.println(ansListOptimised);
    }

    public static List<List<Integer>> listOptimised(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        if (n < 4) return result;

        Arrays.sort(arr);


        for (int i=0; i<n-3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            for (int j=i+1; j<n-2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                int left = j+1;
                int right = arr.length-1;

                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));

                        left++;
                        right--;

                        // skip duplicate left
                        while (left < right && arr[left] == arr[left - 1]) left++;

                        // skip duplicate right
                        while (left < right && arr[right] == arr[right + 1]) right--;

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }

        }

        return result;
    }

    public static List<List<Integer>> listBruteForce(int[] arr, int target) {
        Set<List<Integer>> ansSet = new HashSet<>();
        int n = arr.length;

        for (int i=0; i<n-3; i++) {
            for (int j=i+1; j<n-2; j++) {
                for (int k=j+1; k<n-1; k++) {
                    for (int l=k+1; l<n; l++) {
                        long sum = (long) arr[i] + (long) arr[j] + (long) arr[k] + (long) arr[l];

                        if (sum == target) {
                            List<Integer> quad = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(quad);
                            ansSet.add(quad);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ansSet);
    }
}
