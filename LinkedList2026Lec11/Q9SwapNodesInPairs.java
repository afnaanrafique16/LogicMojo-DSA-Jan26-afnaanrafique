package src.LinkedList2026Lec11;

public class Q9SwapNodesInPairs {
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

        Node ansSwapNodesInPairs = swapNodesInPairs(node);
        printList(ansSwapNodesInPairs);
    }

    public static void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node swapNodesInPairs(Node node) {
        // single element or no element => return node
        if (node == null || node.next == null) {
            return node;
        }

        Node dummy = new Node(0);
        dummy.next = node;

        Node prev = dummy;

        // any time u write these loops think from NPE safe perspective
        while (prev.next != null && prev.next.next != null) {

            // [prev] -> A -> B -> [next]
            Node A = prev.next;
            Node B = prev.next.next;  // => A.next

            A.next = B.next;
            B.next = A;
            prev.next = B;

            prev = A;
        }

        return dummy.next;
    }
}
