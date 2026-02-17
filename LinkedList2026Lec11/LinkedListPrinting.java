package src.LinkedList2026Lec11;

public class LinkedListPrinting {

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

        printList(node);
        System.out.println();

        node = insertAtBeg(99, node);
        printList(node);
        System.out.println();

        node = insertAtPos(100, node,3);
        printList(node);
        System.out.println();

        node = insertAtLast(101, node);
        printList(node);
        System.out.println();

        node = deleteAtBeg(node);
        printList(node);
        System.out.println();

        node = deleteAtPos(node,2);
        printList(node);
        System.out.println();

        node = deleteAtLast(node);
        printList(node);
    }

    public static Node deleteAtLast(Node node) {
        Node temp = node;
        Node secondLast = node;

        while (temp.next != null) {
            secondLast = temp;
            temp = temp.next;
        }

        secondLast.next = null;
        return node;
    }

    public static Node deleteAtPos(Node node, int pos) {
        Node temp = node;
        for (int i=1; i<pos-1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return node;
    }

    public static Node deleteAtBeg(Node node) {
        Node temp = node;
        temp = temp.next;
        return temp;
    }

    public static Node insertAtLast(int data, Node node) {
        Node newNode = new Node(data);
        Node temp = node;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = null;
        return node;
    }


    public static Node insertAtPos(int data, Node node, int pos) {
        Node newNode = new Node(data);
        Node temp = node;

        for (int i=1; i<pos-1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        return node;
    }

    public static Node insertAtBeg(int data, Node node) {
        Node newNode = new Node(data);
        newNode.next = node;
        return newNode;
    }

    public static void printList(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
