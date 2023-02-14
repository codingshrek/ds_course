package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;

public class LargestBst {

    public LargestNodeInfo largestBst(TreeNode node) {

        if (node == null) {
            return new LargestNodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        LargestNodeInfo left = largestBst(node.left);
        LargestNodeInfo right = largestBst(node.right);

        if (left.max < node.val && node.val < right.min) {
            return new LargestNodeInfo(left.size + right.size + 1, Math.min(node.val, left.min), Math.max(node.val, right.max));
        }

        return new LargestNodeInfo(Math.max(left.size,right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(14);
        node.right = new TreeNode(13);

       /* node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(14);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(6);
        node.left.left.left = new TreeNode(1);
        node.left.left.right = new TreeNode(2);*/

        LargestBst bst =new LargestBst();
        System.out.println(bst.largestBst(node).size);
    }

}

class LargestNodeInfo {

    public int size;
    public int max;
    public int min;

    public LargestNodeInfo() {

    }

    public LargestNodeInfo(int size, int min, int max) {
        this.size = size;
        this.min = min;
        this.max = max;
    }

}