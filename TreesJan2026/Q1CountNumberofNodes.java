package src.TreesJan2026;

public class Q1CountNumberofNodes {
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
        node.right.right = new Node(7);

        int ansCountOfNodes = countOfNodes(node);
        System.out.println(ansCountOfNodes);
    }

    public static int countOfNodes(Node node) {
        // Base case (smallest possible I/P)
        if (node == null) {
            return 0;
        }

        int l = countOfNodes(node.left);
        int r = countOfNodes(node.right);
        int ans = 1+l+r;

        return ans;
    }
}
