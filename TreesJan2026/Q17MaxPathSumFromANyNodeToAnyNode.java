package src.TreesJan2026;

public class Q17MaxPathSumFromANyNodeToAnyNode {
    public static int maxSum = Integer.MIN_VALUE;
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(-10);
        node.left = new Node(9);
        node.right = new Node(20);
        node.right.left = new Node(15);
        node.right.right = new Node(7);

        int ansMaxPathSum = maxPathSumFun(node);
        System.out.println(ansMaxPathSum);
    }

    public static int maxPathSumFun(Node node) {
        maxSum=Integer.MIN_VALUE;

        helper(node);

        return maxSum;
    }

    public static int helper(Node node) {
        if (node == null) {
            return 0;
        }

        int l = Math.max(0, helper(node.left));
        int r = Math.max(0, helper(node.right));

        int currentMaxPathSum = Math.max(node.data, node.data + Math.max(l, r));

        int throughNode = l+r+node.data;

        maxSum = Math.max(maxSum, Math.max(currentMaxPathSum, throughNode));

        return currentMaxPathSum;
    }
}
