package src.BacktrackingJan2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q5CombinationSum2 {
    public static void main(String[] args) {
//        int[] candidates = {10,1,2,7,6,1,5};
//        int target = 8;

        int[] candidates = {2,5,2,1,2};
        int target = 5;

        List<List<Integer>> ansList = combinationSum2(candidates, target);
        System.out.println(ansList);
    }

    public static List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int sum = 0;

        // array might be unsorted and we need to handle duplicates
        Arrays.sort(arr);

        backtrackCS2(arr, target, ansList, current, sum, 0);

        return ansList;
    }

    public static void backtrackCS2(int[] arr, int target, List<List<Integer>> ansList, List<Integer> current, int sum, int index) {
        if (sum == target) {
            ansList.add(new ArrayList<>(current));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i=index; i<arr.length; i++) {
            // ignore all the elements apart from first index
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            //add
            current.add(arr[i]);
            sum+=arr[i];

            //explore
            // taking i+1, because we don't want the same number to be repeated.
            backtrackCS2(arr, target, ansList, current, sum, i+1);

            //remove
            current.remove(current.size()-1);
            sum-=arr[i];
        }
    }


}
