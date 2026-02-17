package src.LinkedList2026Lec11;

public class Q7ReverseALinkedList {
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

        node = reverseFun(node);
        printList(node);
    }

    public static Node reverseFun(Node node) {
        Node prev = null;
        Node currNode = node;

        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }

        // new head of the reversed linked list
        return prev;
    }

    public static void printList(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
