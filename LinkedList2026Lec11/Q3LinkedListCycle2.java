package src.LinkedList2026Lec11;

public class Q3LinkedListCycle2 {
    public static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(2);
        node.next.next = new Node(0);
        node.next.next.next = new Node(-1);
        node.next.next.next.next = node.next;

        Node ansStartOfCycleNode = startOfCycleNode(node);
        System.out.println(ansStartOfCycleNode.data);
    }

    public static Node startOfCycleNode(Node node) {
        if(node == null || node.next == null) {
            return null;
        }

        Node meetingNode = fastAndSlowMeeting(node);
        Node start = node;

        // if the list has no meeting point
        if (meetingNode == null) {
            return null;
        }

        while (start != meetingNode) {
            start = start.next;
            meetingNode = meetingNode.next;
        }

        // return start/meetingNode
        return start;
    }

    public static Node fastAndSlowMeeting(Node node) {
        Node slow = node;
        Node fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return slow;
            }
        }

        return null;
    }
}
