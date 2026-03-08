package src.HashSetJan2026;

import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(1);

        System.out.println(hashSet);
        System.out.println(hashSet.size());
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(10));
        System.out.println(hashSet.remove(1));
        System.out.println(hashSet);


    }
}
