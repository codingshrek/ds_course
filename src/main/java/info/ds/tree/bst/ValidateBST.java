package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;

public class ValidateBST {

    public Boolean validateBST(Integer low, Integer high, TreeNode node) {

        if (node == null) {
            return true;
        }
        Integer curVal = node.val;
        if (curVal < low || curVal > high) return false;

        return validateBST(low, curVal, node.left) && validateBST(curVal, high, node.right);
    }

}
