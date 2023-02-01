package info.ds.tree.bt.leetcode;

/**
 * Check for symmetry
 */
public class Question101 {

    public boolean checkForSymmetry(TreeNode n1, TreeNode n2){
        if(n1==null || n2 == null){
            return n1==n2;
        }

        return (n1.val == n2.val) && checkForSymmetry(n1.left,n2.right) && checkForSymmetry(n1.right,n2.left);

    }

    public boolean isSymmetric(TreeNode root) {
        return checkForSymmetry(root.left,root.right);
    }

}
