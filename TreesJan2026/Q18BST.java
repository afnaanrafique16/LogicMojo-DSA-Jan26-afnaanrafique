package src.TreesJan2026;

public class Q18BST {
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
        Node node = new Node(8);
        node.left = new Node(3);
        node.right = new Node(10);
        node.left.left = new Node(1);
        node.left.right = new Node(6);
        node.left.right.left = new Node(4);
        node.left.right.right = new Node(7);
        node.right.right = new Node(14);
        node.right.right.left = new Node(13);

        inorder(node);
        System.out.println();

        int target = 6;

        boolean ansSearchInBST = searchInBst(node, target);
        System.out.println(ansSearchInBST);
    }

    // L Roo R
    public static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public static boolean searchInBst(Node node, int target) {
        if (node == null) {
            return false;
        }

        if (node.data == target) {
            return true;
        } else if (node.data > target) {
            boolean ans = searchInBst(node.left, target);
            return ans;
        } else {
            boolean ans = searchInBst(node.right, target);
            return ans;
        }
    }
}
