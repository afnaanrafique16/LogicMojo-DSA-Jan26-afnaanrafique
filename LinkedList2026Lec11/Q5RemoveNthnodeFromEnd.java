package src.LinkedList2026Lec11;

public class Q5RemoveNthnodeFromEnd {
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

        int n=2;

//        Node ansRemoveNFromEndUsingLength = removeNFromEndUsingLength(node, n);
//        printList(ansRemoveNFromEndUsingLength);
        System.out.println();

        Node ansRemoveNFromEnd = removeNFromEndFun(node, n);
        printList(ansRemoveNFromEnd);
    }

    public static Node removeNFromEndUsingLength(Node node, int n) {
        int length = 0;
        Node temp = node;
        Node dummy = new Node(0);
        dummy.next = node;

        while (temp !=  null) {
            length++;
            temp = temp.next;
        }

        Node temp1= dummy;
        for (int i=1; i<=length-n; i++) {
            temp1 = temp1.next;
        }

        temp1.next = temp1.next.next;

        return dummy.next;
    }

    public static void printList(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node removeNFromEndFun(Node node, int n) {
        // we need dummy node for the case if we want to delete 5th from last -> 1,2,3,4,5
        Node dummy = new Node(0);
        dummy.next = node;

        Node slow = dummy;
        Node fast = dummy;

        // distance between slow and fast
        for (int i=0; i<n; i++) {
            fast = fast.next;
        }

        // maintain that distance
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // cut the bond
        slow.next = slow.next.next;

        return dummy.next;
    }
}
