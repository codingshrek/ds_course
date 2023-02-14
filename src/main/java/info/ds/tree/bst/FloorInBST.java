package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;

public class FloorInBST {

    Integer floor = Integer.MIN_VALUE;

    public Integer findFloorInBst(Integer key, TreeNode root) {
        if (root == null) return floor;

        Integer rootVal = root.val;
        if (rootVal > key) {
            findFloorInBst(key, root.left);
        } else if (rootVal < key && rootVal > floor) {
            floor = rootVal;
            findFloorInBst(key, root.right);
        }

        return floor;

    }

    public static void main(String[] args) {

    }
}
