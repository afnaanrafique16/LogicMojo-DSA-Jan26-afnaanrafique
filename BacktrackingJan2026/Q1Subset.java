package src.BacktrackingJan2026;

import java.util.ArrayList;
import java.util.List;

public class Q1Subset {
    public static void main(String[] args) {
        int[] arr = {1, 2,3};

        List<List<Integer>> ansListRecursionChoices = recursionChoices(arr);
        System.out.println(ansListRecursionChoices);

        List<List<Integer>> ansListForLoop = listForLoop(arr);
        System.out.println(ansListForLoop);
    }

    public static List<List<Integer>> recursionChoices(int[] arr) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrackRec(arr, ansList, current, 0);

        return ansList;
    }

    public static void backtrackRec(int[] arr, List<List<Integer>> ansList, List<Integer> current, int index) {
        if (index == arr.length) {
            ansList.add(new ArrayList<>(current));
            return;
        }

        //add
        current.add(arr[index]);

        //explore
        backtrackRec(arr, ansList, current, index+1);

        //remove
        current.remove(current.size()-1);

        //explore
        backtrackRec(arr, ansList, current, index+1);
    }

    public static List<List<Integer>> listForLoop(int[] arr) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backTrackForLoop(arr, ansList, current, 0);

        return ansList;
    }

    public static void backTrackForLoop(int[] arr, List<List<Integer>> ansList, List<Integer> current, int index) {
        ansList.add(new ArrayList<>(current));

        // since we want to add numbers onto the right of wherever we are standing
        // that's why i is starting from index
        for (int i=index; i<arr.length; i++) {
            //add
            current.add(arr[i]);

            //explore
            backTrackForLoop(arr, ansList, current, i+1);

            //remove
            current.remove(current.size()-1);
        }
    }
}
