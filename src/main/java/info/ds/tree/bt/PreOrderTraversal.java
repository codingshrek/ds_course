package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.Stack;

public class PreOrderTraversal {


    public void traversal(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.println(root.val);
        traversal(root.left);
        traversal(root.right);

    }

    public void iterativeTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            System.out.println(currentNode);

            if(currentNode.right!=null){
                stack.push(currentNode.right);
            }
            if(currentNode.left!=null){
                stack.push(currentNode.left);
            }
        }


    }




}
