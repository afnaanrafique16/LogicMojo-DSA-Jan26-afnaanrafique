package src.TreesJan2026;

public class TreeTraversal {
    public static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node node =  new Node('A');
        node.left = new Node('B');
        node.right = new Node('C');
        node.left.left = new Node('D');
        node.left.right = new Node('E');
        node.left.right.left = new Node('H');
        node.right.left = new Node('F');
        node.right.right = new Node('G');
        node.right.left.left = new Node('I');
        node.right.right.right = new Node('J');
        node.right.right.right.right = new Node('K');

        preOrder(node);
        System.out.println();

        inOrder(node);
        System.out.println();

        postOrder(node);
    }

    // Roo L R
    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // L Roo R
    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // L R Roo
    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
}
