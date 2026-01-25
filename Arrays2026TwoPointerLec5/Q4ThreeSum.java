package src.Arrays2026TwoPointerLec5;

import java.util.*;

public class Q4ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-3, 0, 1, 2, -1, 1, -2};

        List<List<Integer>> ansThreeSumBruteForce = threeSumBruteForce(arr);
        System.out.println(ansThreeSumBruteForce);


        List<List<Integer>> ansThreeSumOptimised = threeSumOptimised(arr);
        System.out.println(ansThreeSumOptimised);

    }

    public static List<List<Integer>> threeSumBruteForce(int[] arr) {
        HashSet<List<Integer>> globalSet = new HashSet<>();

        for (int i=0; i<=arr.length-3; i++) {
            List<Integer> list = List.of();
            for (int j=i+1; j<=arr.length-2; j++) {
                for (int k=j+1; k<=arr.length-1; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        list = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(list);
                        globalSet.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(globalSet);
    }

    public static List<List<Integer>> threeSumOptimised(int[] arr) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(arr);

        for (int i=0; i<arr.length; i++) {
            // skip duplicate i for -1, 0, 1, 2, -1, 4
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }

            int left = i+1;
            int right = arr.length-1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum < 0) {
                    left++;
                } else if (sum>0) {
                    right--;
                } else {
                    ansList.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;


                    // skip duplicates because of -2, 0, 0, 2, 2
                    while (left < right && arr[left] == arr[left+1]) {
                        left++;
                    }

                    while (left < right && arr[right] == arr[right-1]) {
                        right--;
                    }
                }

            }
        }

        return ansList;
    }
}
