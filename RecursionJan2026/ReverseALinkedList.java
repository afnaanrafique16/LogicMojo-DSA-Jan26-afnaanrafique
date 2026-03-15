package src.RecursionJan2026;

public class ReverseALinkedList {
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
        node.next.next.next.next.next.next = new Node(7);

        System.out.println("Original list : ");
        printList(node);
        System.out.println();

        System.out.println("Reversed List : ");

        node = reverseListRec(node);
        printList(node);
    }

    public static Node reverseListRec(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node l = node;
        Node r = reverseListRec(node.next);
        l.next.next = l;
        l.next = null;

        return r;
    }

    public static void printList(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
