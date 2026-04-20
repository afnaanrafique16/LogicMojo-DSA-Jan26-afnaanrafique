package src.TreesJan2026;

public class Q14SumRootToLeafNumbers {
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
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);

        int ansSumRootToLeaf = sumRootToLeaf(node);
        System.out.println(ansSumRootToLeaf);
    }

    public static int sumRootToLeaf(Node node) {
        return helper(node, 0);
    }

    public static int helper(Node node, int currentNumberFormed) {
        if (node == null) {
            return 0;
        }

        currentNumberFormed = currentNumberFormed*10 + node.data;

        if (node.left == null && node.right == null) {
            return currentNumberFormed;
        }

        int l = helper(node.left, currentNumberFormed);
        int r = helper(node.right, currentNumberFormed);
        int ans = l + r;

        return ans;
    }
}
