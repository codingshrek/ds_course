package info.ds.tree.bt;

import java.util.*;

public class LevelOrderTraversal {

    public List<List<BinaryTree.Node>> traversal(BinaryTree.Node root) {
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        List<List<BinaryTree.Node>> levelOrder = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<BinaryTree.Node> nodes = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    BinaryTree.Node currentNode = queue.poll();
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }

                    nodes.add(currentNode);
                }
            levelOrder.add(nodes);
        }

        return levelOrder;
    }

    public static void main(String args[]) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node root = tree.buildTree(nodes);

        LevelOrderTraversal traversal = new LevelOrderTraversal();
        List<List<BinaryTree.Node>> levelOrderNodes = traversal.traversal(root);


        levelOrderNodes.forEach(i -> System.out.println(i));



    }

}
