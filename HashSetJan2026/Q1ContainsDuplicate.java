package src.HashSetJan2026;

import java.util.HashSet;

public class Q1ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};

        boolean ansContainsDuplicateHashSet = containsDuplicateHashSet(arr);
        System.out.println(ansContainsDuplicateHashSet);

        boolean ansHashsetFun = hashsetFun(arr);
        System.out.println(ansHashsetFun);
    }

    public static boolean hashsetFun(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i=0; i<arr.length; i++) {
            hashSet.add(arr[i]);
        }

        // if size equal => no duplicate
        return !(arr.length == hashSet.size());
    }

    public static boolean containsDuplicateHashSet(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i=0; i<arr.length; i++) {
            if (!hashSet.contains(arr[i])) {
                hashSet.add(arr[i]);
            } else {
                return true;
            }
        }

        return false;
    }
}
