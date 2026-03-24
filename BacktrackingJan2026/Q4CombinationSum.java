package src.BacktrackingJan2026;

import java.util.ArrayList;
import java.util.List;

public class Q4CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> ansList = combinationSumFun(candidates, target);
        System.out.println(ansList);
    }

    public static List<List<Integer>> combinationSumFun(int[] arr, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int sum=0;

        backtrackFun(arr, target, ansList, current, sum, 0);
        return ansList;
    }

    public static void backtrackFun(int[] arr, int target, List<List<Integer>> ansList, List<Integer> current, int sum, int index) {
        if (sum == target) {
            ansList.add(new ArrayList<>(current));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i=index; i<arr.length; i++) {
            //add
            sum+=arr[i];
            current.add(arr[i]);

            //explore
            backtrackFun(arr, target, ansList, current, sum, i);

            //remove
            current.remove(current.size()-1);
            sum-=arr[i];
        }
    }
}
