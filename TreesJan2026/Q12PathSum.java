package src.TreesJan2026;

public class Q12PathSum {
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

        int targetSum = 10;

        boolean ansHasPathSum = hasPathSumFun(node, targetSum);
        System.out.println(ansHasPathSum);
    }

    public static boolean hasPathSumFun(Node node, int targetSum) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null && node.data == targetSum) {
            return true;
        }

        boolean l = hasPathSumFun(node.left, targetSum-node.data);
        if (l == true) {
            return true;
        }
        boolean r = hasPathSumFun(node.right, targetSum-node.data);

        if (r == true) {
            return true;
        }

        boolean ans = l || r;

        return ans;
    }
}
