package src.QueueJan2026;

import java.util.LinkedList;
import java.util.Queue;

public class Q1PrintFirstnBinaryNumbers {
    public static void main(String[] args) {
        generateBinaryNumbers(5);
    }

    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i=1; i<=n; i++) {
            String num = queue.poll();
            System.out.print(num + " ");

            queue.add(num + "0");
            queue.add(num + "1");
        }
    }
}
