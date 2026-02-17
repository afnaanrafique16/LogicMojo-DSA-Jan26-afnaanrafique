package src.LinkedList2026Lec11;

public class Q8ReverseLinkedList2 {
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

        int left = 2;
        int right = 4;

        Node ansReverseSublist = reverseSubList(node, left, right);
        printList(ansReverseSublist);
    }

    public static void printList(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node reverseSubList(Node node, int left, int right) {
        if (node == null || left == right) return node; // I/P = 5 => O/P = 5

        Node dummy = new Node(0);
        dummy.next = node;

        Node nodeBeforeFirst = dummy;
        for (int i = 1; i < left; i++) {
            nodeBeforeFirst = nodeBeforeFirst.next;
        }

        Node first = nodeBeforeFirst.next;

        Node nodeAfterLast = first;
        for (int i = left; i <= right; i++) {
            nodeAfterLast = nodeAfterLast.next;
        }

        // reverse the elements between l and r
        Node prev = null;
        Node curr = first;
        while (curr != nodeAfterLast) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        nodeBeforeFirst.next = prev;
        first.next = nodeAfterLast;

        return dummy.next;
    }
}
