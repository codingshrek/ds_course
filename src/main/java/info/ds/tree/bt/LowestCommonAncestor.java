package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

public class LowestCommonAncestor {


    public Integer lowestCommonAncestor(Integer node1, Integer node2, TreeNode root) {

        if (root == null) {
            return null;
        }
        if (root.val == node1 || root.val == node2) {
            return root.val;
        }


        Integer left = lowestCommonAncestor(node1, node2, root.left);
        Integer right = lowestCommonAncestor(node1, node2, root.right);

        if (left != null && right != null) return root.val; // we have found the solution
        if (left != null) return left; //Idea is to return not null value if any of the left/right is not null.
        else return right;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        LowestCommonAncestor lca = new LowestCommonAncestor();
        System.out.println(lca.lowestCommonAncestor(5, 3, node));

    }
}
