package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.Stack;

public class PostOrderTraversal {

    public void traversal(TreeNode root) {

        if (root == null) {
            return;
        }


        traversal(root.left);
        traversal(root.right);
        System.out.println(root.val);

    }

    public void postOrderIterativeUsing2Stack(TreeNode node) {

        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        st1.push(node);

        while (!st1.isEmpty()) {
            TreeNode cur = st1.pop();
            st2.push(cur.val);
            if (cur.left != null) st1.push(cur.left);
            if (cur.right != null) st1.push(cur.right);

        }

        while (!st2.isEmpty()) {
            System.out.println(st2.pop());
        }





    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right= new TreeNode(3);

        node.left.left =new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.right =new TreeNode(6);

        PostOrderTraversal t = new PostOrderTraversal();
        t.postOrderIterativeUsing2Stack(node);


    }


}
