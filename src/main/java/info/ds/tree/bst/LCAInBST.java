package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;

/**
 * Point at which path is splitting while going down is the LCA in BST.
 */
public class LCAInBST {


    public TreeNode lcaInBST(Integer p, Integer q, TreeNode node){

        if(node == null){
            return null;
        }
        Integer curVal = node.val;
        if(p>curVal && q>curVal) return lcaInBST(p,q,node.right);
        if(p<curVal && q<curVal) return lcaInBST(p,q,node.left);

        return node;
    }


}
