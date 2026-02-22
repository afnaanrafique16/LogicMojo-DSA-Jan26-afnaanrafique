package src.StackJan2026;

import java.util.Stack;

public class Q8CelebrityProblem {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };

        int ansCelebrityProblemBruteForce = celebrityProblemBruteForce(arr);
        System.out.println(ansCelebrityProblemBruteForce);

        int ansCelebrityProblemUsingStack = celebrityProblemUsingStack(arr);
        System.out.println(ansCelebrityProblemUsingStack);

        int ansCelebrityWithoutSpace = celebrityProblemWithoutSpace(arr);
        System.out.println(ansCelebrityWithoutSpace);
    }

    // O(n^2)
    public static int celebrityProblemBruteForce(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            boolean isCelebrity = true;
            for (int j=0; j<arr.length; j++) {
                if (i != j) {
                    if (knows(arr, i, j) || !knows(arr, j, i)) {
                        isCelebrity = false;
                        break;
                    }
                }
            }

            if (isCelebrity){
                return i;
            }
        }

        return -1; // no celebrity
    }

    // T(n) => O(n), A(n) = O(n)
    public static int celebrityProblemUsingStack(int[][] arr) {
        Stack<Integer> stack = new Stack<>();

        // pushing all the persons to the stack
        for (int i=0; i<arr.length; i++) {
            stack.push(i);
        }

        // popping two persons at a time
        while (stack.size() >= 2) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(arr, a, b)) {
                // a knows b => DEF a is not celebrity
                stack.push(b);
            } else {
                // a does not know b => DEF b is not a celebrity
                stack.push(a);
            }
        }

        // left with one element onto the stack
        int candidate = stack.pop();

        for (int i=0; i< arr.length; i++) {
            if (i != candidate) {
                // not fulfilling the criteria of being a celebrity, return -1
                if (knows(arr, candidate, i) || !knows(arr, i, candidate)) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    public static int celebrityProblemWithoutSpace(int[][] arr) {
        int i=0; // representing the first person
        int j=arr.length-1; // representing the last person

        while (i < j) {
            if (knows(arr, i, j)) {
                // i knows j => i cannot be celebrity
                i++;
            } else {
                // j knows i => j cannot be a celebrity
                j--;
            }
        }

        int candidate = i;  // or candidate = j

        // whether this candidate is actually celebrity or not
        for (int p=0; p<arr.length; p++) {
            if (p != candidate) {
                if (!knows(arr, p, candidate) || knows(arr, candidate, p)) {
                    // it is NOT a celebrity
                    return -1;
                }
            }
        }


        /*
        for (int k = 0; k < n; k++) {

    if (k == cand) {
        continue;   // skip checking candidate with themselves
    }

    boolean candidateKnowsK = (M[cand][k] == 1);
    boolean kKnowsCandidate = (M[k][cand] == 1);

    // Rule 1: candidate should NOT know anyone
    if (candidateKnowsK) {
        return -1;   // fails celebrity condition
    }

    // Rule 2: everyone should know candidate
    if (!kKnowsCandidate) {
        return -1;   // fails celebrity condition
    }
}
         */

        return candidate;
    }

    public static boolean knows(int[][] arr, int a, int b) {
        if (arr[a][b] == 1) {
            return true;
        }

        return false;
    }
}
