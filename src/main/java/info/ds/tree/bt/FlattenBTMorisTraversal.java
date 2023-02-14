package info.ds.tree.bt;

import info.ds.tree.bst.SearchElement;
import info.ds.tree.bt.leetcode.TreeNode;

public class FlattenBTMorisTraversal {

    public void flattenBt(TreeNode root) {

        TreeNode cur = root;
        while (cur != null) {

            if (cur.left == null) {
                cur = cur.right;
            } else {

                TreeNode temp = cur.left;
                if (cur.right != null) {
                    while (temp.right != null && temp.right.val != cur.right.val) {
                        temp = temp.right;
                    }
                    temp.right = cur.right;
                }

                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;

            }

        }

    }

    public void iterateOnFlattenBT(TreeNode node) {

        while (true) {
            if (node == null) break;
            System.out.println(node.val);
            node = node.right;
        }

    }


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

        FlattenBTMorisTraversal bt = new FlattenBTMorisTraversal();
        bt.flattenBt(node);

        bt.iterateOnFlattenBT(node);


    }

}
