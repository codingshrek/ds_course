package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

public class FlattenBinaryTree {

    private TreeNode prev = null;

    public void flattenBinaryTreeRecursive(TreeNode node) {
        if (node == null) return;

        flattenBinaryTreeRecursive(node.right);
        flattenBinaryTreeRecursive(node.left);

        node.right = prev;
        node.left = null;
        prev = node;


    }

    public void iterateOnFlattenBT(TreeNode node) {

        while (true) {
            if (node == null) break;
            System.out.println(node.val);
            node = node.right;
        }

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(6);

        FlattenBinaryTree bt = new FlattenBinaryTree();
        bt.flattenBinaryTreeRecursive(node);

        bt.iterateOnFlattenBT(node);


    }

}
