package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorisTraversalInorder {

    public List<Integer> morrisTraversalInorder(TreeNode node) {
        List<Integer> inOrder = new ArrayList<>();

        TreeNode cur = node;
        while (cur != null) {

            if (cur.left == null) {
                inOrder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inOrder.add(cur.val);
                    cur = cur.right;

                }

            }

        }
        return inOrder;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.right = new TreeNode(6);
        MorisTraversalInorder in = new MorisTraversalInorder();
        System.out.println(in.morrisTraversalInorder(node));
    }
}
