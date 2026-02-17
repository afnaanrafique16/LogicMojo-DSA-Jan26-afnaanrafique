package src.LinkedList2026Lec11;

public class Q2MiddleOsTheLinkedList {
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
        node.next.next.next.next.next = new Node(6);

        Node ansMiddleSecondNode = secondMiddleNodeFun(node);
        System.out.println(ansMiddleSecondNode.data);

        Node ansFirstMiddleNode = firstMiddleNode(node);
        System.out.println(ansFirstMiddleNode.data);
    }

    public static Node firstMiddleNode(Node node) {
        Node fast = node;
        Node slow = node;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public static Node secondMiddleNodeFun(Node node) {
        Node fast = node;
        Node slow = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
