package src.TreesJan2026;

public class Q15LowestCommonAncestor {
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
        Node node = new Node(3);
        node.left = new Node(5);
        node.right = new Node(1);
        node.left.left = new Node(6);
        node.left.right = new Node(2);
        node.left.right.left = new Node(7);
        node.left.right.right = new Node(4);
        node.right.left = new Node(0);
        node.right.right = new Node(8);

        Node p = node.left;
        Node q = node.right;

        Node lca = lcaFun(node, p, q);
        System.out.println(lca.data);
    }

    public static Node lcaFun(Node node, Node p, Node q) {
        if (node == null) {
            return null;
        }

        if (node == p || node == q) {
            return node;
        }

        Node l = lcaFun(node.left, p, q);
        Node r = lcaFun(node.right, p, q);

        if (l == null) {
            return r;
        }

        if (r == null) {
            return l;
        }

        /* common node bw the two nodes
        if (l != null && r != null)
            return node;
         */
        return node;
    }
}
