package info.ds.tree.bt.leetcode;

/**
 * Same tree check
 */
public class Question100 {

    public boolean isSameTree(TreeNode node1, TreeNode node2) {

        if (node1 == null || node2 == null) {
            return (node1 == node2);
        }

        boolean left = isSameTree(node1.left, node2.left);
        boolean right = isSameTree(node1.right, node2.right);


        return (node1.val == node2.val) && left && right;

    }

}
