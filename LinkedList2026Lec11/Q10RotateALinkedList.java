package src.LinkedList2026Lec11;

public class Q10RotateALinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
//        Node node = new Node(1);
//        node.next = new Node(2);
//        node.next.next = new Node(3);
//        node.next.next.next = new Node(4);
//        node.next.next.next.next = new Node(5);

        //int k=2;

        Node node = new Node(0);
        node.next = new Node(1);
        node.next.next = new Node(2);
        int k = 4;

        Node ansRotateList = rotateList(node, k);
        printList(ansRotateList);
    }

    public static void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node rotateList(Node node, int k) {
        if (node == null || node.next == null || k == 0) {
            // Edge case: If the list is empty, has one node, or k is 0, no rotation is needed.
            return node;
        }


        int len = 0;
        Node temp = node;

        // calculate the length of the linked list
        while(temp != null) {
            len++;
            temp = temp.next;
        }

        k = k % len;
        if (k == 0) {
            // No need to rotate if k is a multiple of the list's length
            return node;
        }

        Node fast = node;
        Node slow = node;

        // give a head-start to the fast pointer as many times as the k value
        for (int i=0; i<k; i++) {
            fast = fast.next;
        }

        // maintain the deficit till you reach the end, slow pointer will be at a distance
        // equal to k at last
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        Node ans = slow.next;
        slow.next = null;
        fast.next = node;  // head of the linked list

        return ans;
    }
}
