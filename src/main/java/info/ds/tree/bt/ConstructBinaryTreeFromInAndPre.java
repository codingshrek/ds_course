package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInAndPre {


    private TreeNode construct(int inStart, int inEnd, int[] inOrder, int preStart, int preEnd, int[] preOrder, Map<Integer, Integer> inMap) {

        if (inStart > inEnd || preStart > preEnd) return null;

        TreeNode root = new TreeNode(preOrder[preStart]);
        Integer inRootPos = inMap.get(root.val);

        Integer numsToLeft = inRootPos - inStart;

        root.left = construct(inStart, inRootPos - 1, inOrder, preStart + 1, preStart + numsToLeft, preOrder, inMap);
        root.right = construct(inRootPos + 1, inEnd, inOrder, preStart + numsToLeft + 1, preEnd, preOrder, inMap);

        return root;
    }

    public TreeNode constructTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(preOrder[i], i);
        }

        TreeNode root = construct(0, inOrder.length - 1, inOrder, 0, preOrder.length - 1, preOrder, inMap);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInAndPre bt = new ConstructBinaryTreeFromInAndPre();
        int[] preOrder = {10, 20, 40, 50, 30, 60};
        int[] inOrder = {40, 20, 50, 10, 60, 30};

        TreeNode root = bt.constructTree(preOrder, inOrder);

        PreOrderTraversal traversal = new PreOrderTraversal();
        traversal.traversal(root);

    }

}
