package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;

public class SuccessorOfNode {

    public TreeNode findSuccessor(TreeNode key, TreeNode root) {

        TreeNode sucessor = null;
        while (root != null) {

            if (key.val > root.val) {
                root = root.right;
            } else {
                sucessor = root;
                root = root.left;
            }
        }

        return sucessor;

    }

}
