package info.ds.tree.bt.leetcode;

public class Question112 {


    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null){
            return false;
        }
        if (root.left == null && root.right == null) {
            targetSum = targetSum - root.val;
            if (targetSum == 0) {
                return true;
            }
            return false;
        }
        targetSum = targetSum - root.val;

        boolean left = hasPathSum(root.left, targetSum);
        boolean right = hasPathSum(root.right, targetSum);

        return left || right;
    }

}
