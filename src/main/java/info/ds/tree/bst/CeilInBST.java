package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;

public class CeilInBST {

    Integer ceil = Integer.MAX_VALUE;

    public Integer findCeilInBst(Integer key, TreeNode root) {
        if (root == null) return ceil;

        Integer rootVal = root.val;
        if (rootVal > key && ceil > rootVal) {
            ceil = rootVal;
            findCeilInBst(key, root.left);
        } else if (rootVal < key) {
            findCeilInBst(key, root.right);
        }

        return ceil;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(5);
        node.right = new TreeNode(13);

        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(14);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(6);
        node.left.left.left = new TreeNode(1);
        node.left.left.right = new TreeNode(2);

        CeilInBST ceil = new CeilInBST();
        System.out.println(ceil.findCeilInBst(7,node));
    }
}
