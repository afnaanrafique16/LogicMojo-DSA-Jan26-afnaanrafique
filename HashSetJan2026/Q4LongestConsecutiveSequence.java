package src.HashSetJan2026;

import java.util.HashSet;

public class Q4LongestConsecutiveSequence {
    public static void main(String[] args) {
        //int[] arr = {100,4,200,1,3,2};
        int[] arr = {0,3,7,2,5,8,4,6,0,1};

        int ansLongestConsecutiveSequence = longestConsecutiveSequence(arr);
        System.out.println(ansLongestConsecutiveSequence);
    }

    public static int longestConsecutiveSequence(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        int maxLength = 0;

        for (int i=0; i<arr.length; i++) {
            hashSet.add(arr[i]);
        }

        for (int num: hashSet) {
            // check whether the number is qualified to become start of sequence
            // if it is qualified then only do the computation
            if (!hashSet.contains(num - 1)) {
                int current = num;
                int len = 1;

                while (hashSet.contains(current + 1)) {
                    len++;
                    current++;
                }

                maxLength = Math.max(maxLength, len);
            }
        }

        return maxLength;

    }
}
