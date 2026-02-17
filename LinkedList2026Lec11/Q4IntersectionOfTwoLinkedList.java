package src.LinkedList2026Lec11;

public class Q4IntersectionOfTwoLinkedList {
    public static class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);

        Node node2 = new Node(8);
        node2.next = new Node(6);
        node2.next.next = node1.next.next.next;

        Node ansIntersectionOfTwoLinkedList = intersectionOfTwoLinkedList(node1, node2);
        System.out.println(ansIntersectionOfTwoLinkedList.data);

        Node ansIntersectionOfTwoListContextSwitching = intersectionOfTwoListContextSwitching(node1, node2);
        System.out.println(ansIntersectionOfTwoListContextSwitching.data);
    }

    public static Node intersectionOfTwoListContextSwitching(Node node1, Node node2) {

        if (node1 == null || node2 == null) {
            return null;
        }

        Node a = node1;
        Node b = node2;

        while (a != b) {
            a = (a ==null) ? node2 : a.next;
            b = (b == null) ? node1 : b.next;
        }

        // a or b
        return a;
    }

    public static Node intersectionOfTwoLinkedList(Node node1, Node node2) {
        int length1 = length(node1);
        int length2 = length(node2);

        int lengthDiff = Math.abs(length1 - length2);
        Node temp1 = node1;
        Node temp2 = node2;
        if (length1 > length2) {
            // give head start to n1
            for (int i=1; i<=lengthDiff; i++) {
                temp1 = temp1.next;
            }
        } else {
            for (int i=1; i<=lengthDiff; i++) {
                temp2 = temp2.next;
            }
        }

        // both lists are even now, iterate one by one and the meeting point is the intersection point
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp2;
    }

    public static int length(Node node) {
        int len = 0;
        Node temp = node;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }
}
Q4IntersectionOfTwoLinkedList.java
