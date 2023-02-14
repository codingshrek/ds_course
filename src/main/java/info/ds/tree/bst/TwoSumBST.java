package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;

/**
 * Brute Force : Do an inorder traversal , store in an array and the problem boils down to Two Sum problem.
 * Optimal : we to inorder traversal using BST iterator
 */
public class TwoSumBST {

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

        BstInorderIterator iterator = new BstInorderIterator(node);
        int target = 99;
        int first  = iterator.next().val;
        int last = iterator.prev().val;
        while (first<last) {

            if(first+last==target){
                System.out.println("First = "+first+" last = "+last+" target = "+target);
                break;
            }
            if(first+last>target){
                last = iterator.prev().val;
            }
            else {
                first= iterator.next().val;
            }

        }

    }
}
