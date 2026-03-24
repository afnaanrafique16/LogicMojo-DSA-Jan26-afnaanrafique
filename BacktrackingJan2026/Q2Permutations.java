package src.BacktrackingJan2026;

import java.util.ArrayList;
import java.util.List;

public class Q2Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2};

        List<List<Integer>> ansList = permutationsBT(nums);
        System.out.println(ansList);
    }

    public static List<List<Integer>> permutationsBT(int[] arr) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        // boolean array to track the elements that have been used so far
        boolean[] used = new boolean[arr.length];

        backtrackFun(arr, ansList, current, used, 0);

        return ansList;
    }

    public static void backtrackFun(int[] arr, List<List<Integer>> ansList, List<Integer> current, boolean[] used, int index) {
        if (index == arr.length) {
            ansList.add(new ArrayList<>(current));
            return;
        }

        for (int i=0; i<arr.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            //add
            current.add(arr[i]);

            //explore
            backtrackFun(arr, ansList, current, used, index+1);

            //remove
            current.remove(current.size()-1);

            used[i] = false;
        }

    }
}
