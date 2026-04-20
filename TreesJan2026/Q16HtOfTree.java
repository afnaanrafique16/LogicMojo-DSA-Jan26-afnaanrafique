package src.TreesJan2026;

public class Q16HtOfTree {
    public static int maxDiameter = 0;
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

        int ansHtOfTree = htOfTree(node);
        System.out.println(ansHtOfTree);

        int ansDiameterOfTreeThroughRoot = diameterOfTreeThroughRoot(node);
        System.out.println(ansDiameterOfTreeThroughRoot);

        int ansDiameterOfTreeFromAnyNodeToAnyNodeBruteForce = diameterOfTreeAnyNodeToAnyNodeBruteForce(node);
        System.out.println(ansDiameterOfTreeFromAnyNodeToAnyNodeBruteForce);

        int ansDiameterOptimised = diameterOptimised(node);
        System.out.println(ansDiameterOptimised);
    }

    public static int htOfTree(Node node) {
        if (node == null) {
            return 0;
        }

        int l = htOfTree(node.left);
        int r = htOfTree(node.right);
        int ans = 1 + Math.max(l, r);
        return ans;
    }

    public static int diameterOfTreeThroughRoot(Node node) {
        if (node == null) {
            return 0;
        }

        int l = htOfTree(node.left);
        int r = htOfTree(node.right);
        int ans = l+r;

        return ans;
    }

    /*
    Case - 1 => Diameter passing through the node

    Case - 2 => Best diameter completely inside left subtree

    Case - 3 => Best diameter completely inside right subtree
     */
    public static int diameterOfTreeAnyNodeToAnyNodeBruteForce(Node node) {
        if (node == null) {
            return 0;
        }

        int lHeight = htOfTree(node.left);
        int rHeight = htOfTree(node.right);
        int throughNode = lHeight+rHeight;

        int lDia = diameterOfTreeAnyNodeToAnyNodeBruteForce(node.left);
        int rDia = diameterOfTreeAnyNodeToAnyNodeBruteForce(node.right);
        int ans = Math.max(throughNode, Math.max(lDia, rDia));

        return ans;
    }

    public static int diameterOptimised(Node node) {
        maxDiameter = 0;
        diameter(node);

        return maxDiameter -1;
    }

    /*
    return ht and update diameter
     */
    public static int diameter(Node node) {
        if (node == null) {
            return 0;
        }

        // calculating ht internally
        // these are hts actually
        int lDia = diameter(node.left);
        int rDia = diameter(node.right);

        int currentHeight = 1 + Math.max(lDia,rDia);

        int diameterThroughNode = 1 + lDia + rDia;

        maxDiameter = Math.max(maxDiameter, Math.max(currentHeight, diameterThroughNode));

        return currentHeight;
    }

}
