package src.HashSetJan2026;

import java.util.HashSet;

public class Q2FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};

        int ansDuplicateNumberHashSet = duplicateNumberHashSet(arr);
        System.out.println(ansDuplicateNumberHashSet);

        int ansDuplicateOptimised = duplicateOptimised(arr);
        System.out.println(ansDuplicateOptimised);
    }

    public static int duplicateNumberHashSet(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i=0; i<arr.length; i++) {
            // check whether the number is already part of hashset or not
            if (!hashSet.contains(arr[i])) {
                hashSet.add(arr[i]);
            } else {
                // duplicate number
                return arr[i];
            }
        }

        return -1;
    }

    public static int duplicateOptimised(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        // Step - 1 Find the meeting point of slow and fast pointer
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Take one pointer at start, other at the meeting point and move them one by one, the point where
        // they meet is the start of the cycle and hence the duplicate value.
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }
}
