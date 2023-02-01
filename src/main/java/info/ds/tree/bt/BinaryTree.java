package info.ds.tree.bt;


public class BinaryTree {

    public static class Node {

        int val;
        Node left;
        Node right;

        public Node(int data) {
            this.val = data;
            this.right = null;
            this.left = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }

    int index = -1;

    //Building tree from PreOrder data
    public Node buildTree(int nodes[]) {
        index++;

        if (nodes[index] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }


}
