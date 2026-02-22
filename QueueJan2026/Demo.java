package src.QueueJan2026;

import java.util.LinkedList;
import java.util.Queue;

public class Demo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue);
        // first element of queue
        System.out.println(queue.peek());

        queue.poll();
        System.out.println(queue);

        queue.offer(10);  // -> q.add(10)
        System.out.println(queue);

        System.out.println(queue.peek());
        queue.poll();

        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
