package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

public class HeightOfCompleteBt {


    public int countNodesInCompleteBT(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) {
            return (2 ^ leftHeight) - 1;
        }

        return countNodesInCompleteBT(root.left) + countNodesInCompleteBT(root.right) + 1;

    }


    public int getRightHeight(TreeNode right) {
        int c = 0;
        while (right != null) {
            right = right.right;
            c++;

        }
        return c;
    }

    public int getLeftHeight(TreeNode left) {
        int c = 0;
        while (left != null) {
            left = left.left;
            c++;
        }
        return c;
    }

}
