package src.TreesJan2026;

import java.util.LinkedList;
import java.util.Queue;

public class Q8LevelOrderSuccessor {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);

        int key = 6;

        Node ansLevelOrderSuccessor = levelOrderSuccessor(node, key);
        System.out.println(ansLevelOrderSuccessor!=null?ansLevelOrderSuccessor.data : -1);
    }

    public static Node levelOrderSuccessor(Node node, int key) {
        if (node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i=0; i<queueSize; i++) {
                Node removedNode = queue.poll();

                if (removedNode.left != null) {
                    queue.add(removedNode.left);
                }

                if (removedNode.right != null) {
                    queue.add(removedNode.right);
                }

                if (removedNode.data == key) {
                    return queue.peek();
                }
            }
        }

        return null;
    }
}
