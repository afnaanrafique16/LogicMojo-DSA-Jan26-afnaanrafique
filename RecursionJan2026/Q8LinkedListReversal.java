package src.RecursionJan2026;

public class Q8LinkedListReversal {
    public static class  Node {
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

        printList(node);
        System.out.println();

        node = reverseListIterative(node);
        printList(node);
        System.out.println();

        node = reverseListRecursive(node);
        printList(node);
    }

    public static Node reverseListRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node l = node;
        Node r = reverseListRecursive(node.next);
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

    public static Node reverseListIterative(Node node) {
        Node prev = null;
        Node curr = node;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
