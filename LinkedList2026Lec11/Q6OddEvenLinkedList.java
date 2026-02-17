package src.LinkedList2026Lec11;

public class Q6OddEvenLinkedList {
    public static class Node {
        int data;
        Node next;
        Node (int data) {
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

        node = oddEvenLinkedList(node);
        printList(node);
    }

    public static Node oddEvenLinkedList(Node node) {
        // not necessary to take dummy node
        // You need a dummy node only if the head might change.
        // head here is always odd
        Node dummy = new Node(0);
        dummy.next = node;

        Node odd = node;
        Node even = odd.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            // make the odd point to next of next
            odd.next = even.next;
            odd = odd.next;

            // make the even point to next of odd
            even.next = odd.next;
            even = even.next;
        }

        // make the odd point to the initial even start pointer
        odd.next = evenHead;

        return dummy.next;
    }

    public static void printList(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
