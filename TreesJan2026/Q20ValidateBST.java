package src.TreesJan2026;

public class Q20ValidateBST {
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
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(15);
        node.left.left = new Node(2);
        node.left.right = new Node(7);
        node.right.right = new Node(20);

        boolean ansIsValidBST = isValidBstFun(node);
        System.out.println(ansIsValidBST);
    }

    public static boolean isValidBstFun(Node node) {
        boolean ans = helper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return ans;
    }

    public static boolean helper(Node node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        boolean l = helper(node.left, min, node.data);
        boolean r = helper(node.right, node.data, max);
        boolean ans = l && r;

        return ans;
    }
}
