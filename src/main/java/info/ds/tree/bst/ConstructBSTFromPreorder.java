package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;
import sun.reflect.generics.tree.Tree;

public class ConstructBSTFromPreorder {

    public TreeNode constructBstFromPreOrder(IndexWrapper index, Integer high, int[] preorder) {
        if (index.getIndex() == preorder.length || preorder[index.getIndex()] > high) return null;

        TreeNode node = new TreeNode(preorder[index.getIndex()]);
        index.increment();
        node.left = constructBstFromPreOrder(index, node.val, preorder);
        node.right = constructBstFromPreOrder(index, high, preorder);

        return node;


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
        IndexWrapper index = new IndexWrapper(0);
        ConstructBSTFromPreorder c = new ConstructBSTFromPreorder();
        TreeNode root = c.constructBstFromPreOrder(index, Integer.MAX_VALUE, new int[]{8, 5, 1, 7, 10, 12});
        c.traversal(root);
    }

}

