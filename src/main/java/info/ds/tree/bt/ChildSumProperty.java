package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

/**
 *
 * While going down only change values of child if p>childSum.
 * While backtracking only change value of parent when p<childSum.
 *
 */
public class ChildSumProperty {

    public void childPropertySum(TreeNode node) {

        if (node == null) return;

        TreeNode leftChild = node.left;
        TreeNode rightChild = node.right;

        if (leftChild != null && rightChild != null) {
            Integer childSum = leftChild.val + rightChild.val;
            if (node.val > childSum) {
                Integer diff = node.val - childSum;
                node.left.val = node.left.val + diff;
            }
        } else if (leftChild == null && rightChild != null) {
            Integer childSum = rightChild.val;
            if (node.val > childSum) {
                Integer diff = node.val - childSum;
                node.right.val = node.right.val + diff;
            }
        } else if (rightChild == null && leftChild != null) {
            Integer childSum = leftChild.val;
            if (node.val > childSum) {
                Integer diff = node.val - childSum;
                node.left.val = node.left.val + diff;
            }
        }

        childPropertySum(node.left);
        childPropertySum(node.right);

        TreeNode leftChildB = node.left;
        TreeNode rightChildB = node.right;

        if (leftChildB != null && rightChildB != null) {
            Integer childSum = leftChildB.val + rightChildB.val;
            if (node.val < childSum) {
                node.val = node.left.val + node.right.val;
            }
        } else if (leftChildB == null && rightChild != null) {
            Integer childSum = rightChildB.val;
            if (node.val < childSum) {
                node.val = node.right.val;
            }
        } else if (rightChildB == null && leftChild != null) {
            Integer childSum = leftChildB.val;
            if (node.val > childSum) {
                node.val = node.left.val;
            }
        }
    }

    public void traversal(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.println(root.val);
        traversal(root.left);
        traversal(root.right);

    }

    public static void main(String[] args) {

        /*TreeNode node = new TreeNode(2);
        node.left = new TreeNode(35);
        node.right = new TreeNode(10);

        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(3);

        node.right.left = new TreeNode(8);
        node.right.right = new TreeNode(2);*/


        TreeNode node = new TreeNode(50);
        node.left = new TreeNode(7);
        node.right = new TreeNode(2);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(5);

        node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(30);

        ChildSumProperty csm = new ChildSumProperty();
        csm.childPropertySum(node);

        csm.traversal(node);
    }
}
