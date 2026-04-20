package src.TreesJan2026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q7LevelAverages {
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
        node.left = new Node(9);
        node.right = new Node(20);
        node.right.left = new Node(15);
        node.right.right = new Node(7);

        List<Double> ansList = levelAvg(node);
        System.out.println(ansList);
    }

    public static List<Double> levelAvg(Node node) {
        List<Double> globalList = new ArrayList<>();
        if (node == null) {
            return globalList;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            long sum = 0;
            Double avg;

            for (int i=0; i<queueSize; i++) {
                Node removedNode = queue.poll();

                if (removedNode.left != null) {
                    queue.add(removedNode.left);
                }

                if (removedNode.right != null) {
                    queue.add(removedNode.right);
                }

                // compute total sum for each level
                sum += removedNode.data;
            }

            avg = ((double)sum/queueSize);
            globalList.add(avg);



            /*
            avg = sum/queueSize

            sum -> long
            avg -> Double
            queueSize -> int

            case1 -> avg=sum/queueSize
            it promotes to long division, any fractional part
            is lost
            7/2 -> 3(long division)
            3-> converted to double -> 3.0


            cast this to double, fractional part is not lost
            7/2 -> 3.5
             */
        }

        return globalList;
    }
}
