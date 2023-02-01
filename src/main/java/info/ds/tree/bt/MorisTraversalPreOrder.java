package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorisTraversalPreOrder {


    public List<Integer> morrisTraversalPreorder(TreeNode node) {
        List<Integer> preOrder = new ArrayList<>();

        TreeNode cur = node;
        while (cur != null) {

            if (cur.left == null) {
                preOrder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right != cur) preOrder.add(cur.val);

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }

            }

        }
        return preOrder;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right= new TreeNode(3);

        node.left.left =new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.left.right.right =new TreeNode(6);

        MorisTraversalPreOrder preOrder = new MorisTraversalPreOrder();
        System.out.println(preOrder.morrisTraversalPreorder(node));



    }


}
