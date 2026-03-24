package src.BacktrackingJan2026;

import java.util.ArrayList;
import java.util.List;

public class Q3Subset2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};

        List<List<Integer>> ansList = subset2Fun(nums);
        System.out.println(ansList);
    }

    public static List<List<Integer>> subset2Fun(int[] arr) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrackSubset2(arr, ansList, current, 0);
        return ansList;
    }

    public static void backtrackSubset2(int[] arr, List<List<Integer>> ansList, List<Integer> current, int index) {
        ansList.add(new ArrayList<>(current));

        for (int i=index; i<arr.length; i++) {
            // ignore all the duplicates after first occurence in the same level
            if (i>index && arr[i] == arr[i-1]) {
                continue;
            }

            //add
            current.add(arr[i]);

            //explore
            backtrackSubset2(arr, ansList, current, i+1);

            //remove
            current.remove(current.size()-1);
        }
    }
}
