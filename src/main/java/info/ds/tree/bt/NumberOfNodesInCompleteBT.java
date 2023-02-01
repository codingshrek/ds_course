package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

public class NumberOfNodesInCompleteBT {

    Integer numOfNodes = 0;

    public Integer height(TreeNode node) {
        if (isLeafNode(node)) return 1;


        Integer left = height(node.left);
        Integer right = height(node.right);
        System.out.println("For Node : "+ node.val);
        Integer height = Math.max(left, right) + 1;
        System.out.println("Height : "+height);
        Integer curNodes = 2^height-1;
        System.out.println("Cur Node : "+curNodes);
        numOfNodes = numOfNodes +curNodes;
        System.out.println("Total nodes = "+ numOfNodes);
        System.out.println("------------");
        return height;
    }

    public Integer allNodesInCompleteBT(TreeNode node) {
        if (node == null) return numOfNodes;
        height(node);
        return numOfNodes;
    }

    private boolean isLeafNode(TreeNode node) {

        if (node.left == null && node.right == null) return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        NumberOfNodesInCompleteBT nodes = new NumberOfNodesInCompleteBT();

        System.out.println(nodes.allNodesInCompleteBT(node));

        int[] a = {1,2,3,4,5};

    }
}
