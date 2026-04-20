package src.TreesJan2026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q11LeftRightSideViewOfTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public static void main(String[] args) {
            Node node = new Node(1);
            node.left = new Node(2);
            node.right = new Node(3);
            node.left.left = new Node(4);
            node.left.right = new Node(5);
            node.right.left = new Node(6);
            node.right.right = new Node(7);

            List<Integer> ansLeftViewOfBinaryTree = leftViewOfBinaryTree(node);
            System.out.println(ansLeftViewOfBinaryTree);

            List<Integer> ansRightViewOfBinaryTree = rightViewOfBinaryTree(node);
            System.out.println(ansRightViewOfBinaryTree);
        }

        public static List<Integer> leftViewOfBinaryTree(Node node) {
            List<Integer> ansList = new ArrayList<>();

            if (node == null) {
                return ansList;
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

                    // First node of each level => Left view of a tree
                    if (i == 0) {
                        ansList.add(removedNode.data);
                    }
                }
            }

            return ansList;
        }



        public static List<Integer> rightViewOfBinaryTree(Node node) {
            List<Integer> ansList = new ArrayList<>();

            if (node == null) {
                return ansList;
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

                    // Last node of each level => Right view of tree
                    if (i == queueSize-1) {
                        ansList.add(removedNode.data);
                    }
                }
            }

            return ansList;
        }
    }
}
