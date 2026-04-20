package src.TreesJan2026;

import java.util.ArrayList;
import java.util.List;

public class Q13PathSum2 {
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
            Node node = new Node(5);
            node.left = new Node(4);
            node.right = new Node(8);
            node.left.left = new Node(11);
            node.left.left.left = new Node(7);
            node.left.left.right = new Node(2);
            node.right.left = new Node(13);
            node.right.right = new Node(4);
            node.right.right.left = new Node(5);
            node.right.right.right = new Node(1);

            int targetSum=22;


            List<List<Integer>> globalList = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            pathSum2Fun(node, globalList, list, targetSum);

            System.out.println(globalList);

        }

        public static void pathSum2Fun(Node node, List<List<Integer>> globalList, List<Integer> list, int targetSum) {
            if (node == null) {
                return;
            }

            list.add(node.data);

            // check if the leaf node == targetSum
            if (node.left == null && node.right == null && targetSum == node.data) {
                globalList.add(new ArrayList<>(list));
            }

            //explore both left and right
            pathSum2Fun(node.left, globalList, list, targetSum-node.data);
            pathSum2Fun(node.right, globalList, list, targetSum-node.data);

            // remove the last node of the list
            list.remove(list.size()-1);
        }
    }
}
