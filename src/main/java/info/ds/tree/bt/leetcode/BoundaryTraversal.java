package info.ds.tree.bt.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {


    public List<Integer> boundaryTraversal(TreeNode node) {
        List<Integer> traversal = new ArrayList<>();
        if (node == null) {
            return traversal;
        }
        traversal.add(node.val);
        getLeftBoundaryNodes(node, traversal);
        getLeafNodes(node, traversal);
        getRightBoundaryNodes(node, traversal);

        return traversal;
    }


    public List<Integer> getLeftBoundaryNodes(TreeNode node, List<Integer> traversal) {
        while (true) {
            if (node.left != null) {
                if (!isLeafNode(node.left)) {
                    traversal.add(node.left.val);
                    node = node.left;
                } else {
                    break;
                }
            } else if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    traversal.add(node.right.val);
                    node = node.right;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return traversal;
    }

    public List<Integer> getRightBoundaryNodes(TreeNode node, List<Integer> traversal) {
        Stack<Integer> temp = new Stack<>();
        while (true) {
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    temp.push(node.right.val);
                    node = node.right;
                } else {
                    break;
                }
            } else if (node.left != null) {
                if (!isLeafNode(node.left)) {
                    temp.push(node.left.val);
                    node = node.left;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        while (!temp.isEmpty()) {
            traversal.add(temp.pop());
        }
        return traversal;
    }

    public List<Integer> getLeafNodes(TreeNode node, List<Integer> traversal) {

        if(node==null){
            return traversal;
        }
        if (isLeafNode(node)) {
            traversal.add(node.val);
            return traversal;
        }

        getLeafNodes(node.left, traversal);
        getLeafNodes(node.right, traversal);

        return traversal;
    }


    public boolean isLeafNode(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.right.right.right = new TreeNode(8);

        BoundaryTraversal t = new BoundaryTraversal();
        System.out.println(t.boundaryTraversal(node));


    }

}