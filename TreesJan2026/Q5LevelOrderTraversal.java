package src.TreesJan2026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q5LevelOrderTraversal {
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
        node.right.right = new Node(7);

        List<List<Integer>> ansList = levelOrderTraversal(node);
        System.out.println(ansList);
    }

    public static List<List<Integer>> levelOrderTraversal(Node node) {
        List<List<Integer>> globalList = new ArrayList<>();
        if (node == null) {
            return globalList;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i=0; i<queueSize; i++) {
                Node removedNode = queue.poll();

                if (removedNode.left != null) {
                    queue.add(removedNode.left);
                }

                if (removedNode.right != null) {
                    queue.add(removedNode.right);
                }

                list.add(removedNode.data);
            }

            globalList.add(list);
        }

        return globalList;
    }
}
