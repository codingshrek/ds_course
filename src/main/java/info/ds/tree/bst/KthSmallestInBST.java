package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;

public class KthSmallestInBST {

    public int kthSmallest(TreeNode root, int k) {
        this.counter = k;
        return getKSmallest(root).val;
    }

    int counter = 0;
    public TreeNode getKSmallest(TreeNode root){
        if(root==null){
            return null;
        }

        TreeNode left = getKSmallest(root.left);
        if(left!=null) return left;
        counter--;
        if(counter==0)  return root;

        return getKSmallest(root.right);
    }
}
