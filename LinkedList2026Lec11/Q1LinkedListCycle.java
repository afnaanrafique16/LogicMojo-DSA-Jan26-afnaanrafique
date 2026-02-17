package src.LinkedList2026Lec11;

public class Q1LinkedListCycle {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = node.next.next;

        boolean ansCyclePresent = cyclePresent(node);
        System.out.println(ansCyclePresent);
    }

    public static boolean cyclePresent(Node node) {
        Node fast = node;
        Node slow = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;  // fast moving at 2x the speed than slow

            // if they collide => cycle is present
            if (fast == slow) {
                return true;
            }
        }

        // it is a straight line -> hence no cycle
        return false;
    }

}
