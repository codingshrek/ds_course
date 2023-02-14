package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;

public class PredecessorOfNode {

    public TreeNode findSuccessor(TreeNode key, TreeNode root) {

        TreeNode predecessor = null;
        while (root != null) {

            if (key.val < root.val) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }

        return predecessor;

    }

}
