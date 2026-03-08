package src.HashSetJan2026;

import java.util.HashSet;

public class Q3HappyNumber {
    public static void main(String[] args) {
        int num = 19;

        boolean ansIsHappyNumberHashSet = isHappyNumberHashSet(num);
        System.out.println(ansIsHappyNumberHashSet);

        boolean ansIsHappyNumberFastAndSlowPointer = isHappyNumberFastAndSlowPointer(num);
        System.out.println(ansIsHappyNumberFastAndSlowPointer);
    }

    public static boolean isHappyNumberFastAndSlowPointer(int num) {
        int slow = num;
        int fast = num;

        do {
            slow = getSquareOfDigits(slow);
            fast = getSquareOfDigits(getSquareOfDigits(fast));

            // the moment we get a 1 => HAPPY NUMBER, hence straight away return true
            if (slow == 1) {
                return true;
            }

        } while (fast != slow);

        // since 1 is not reached that means a cycle observed hence return false
        return false;
    }

    public static boolean isHappyNumberHashSet(int num) {
        HashSet<Integer> hashSet = new HashSet<>();

        while (!hashSet.contains(num)) {
            hashSet.add(num);

            num = getSquareOfDigits(num);

            if (num == 1) {
                return true;
            }
        }

        return false;
    }

    public static int getSquareOfDigits(int num) {
        int res=0;

        while (num > 0) {
            /*
            123

            uP = 3

            res = 9
            res = 4 + 9 = 13
            res = 13 + 1 = 14
             */
            int unitsPlace = num%10;

            res += unitsPlace*unitsPlace;
            num = num/10;
        }

        return res;
    }
}
