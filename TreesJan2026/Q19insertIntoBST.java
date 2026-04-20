package src.TreesJan2026;

public class Q19insertIntoBST {
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
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(15);
        node.left.left = new Node(2);
        node.left.right = new Node(7);
        node.right.right = new Node(20);

        int val=18;

        inorder(node);
        System.out.println();

        Node ansInsertIntoBST = insertIntoBSTFun(node, val);
        inorder(ansInsertIntoBST);
    }

    public static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public static Node insertIntoBSTFun(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (val > node.data) {
            node.right = insertIntoBSTFun(node.right, val);
        } else {
            node.left = insertIntoBSTFun(node.left, val);
        }

        return node;
    }
}
