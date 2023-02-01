package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInAndPost {

    private TreeNode construct(int inStart, int inEnd, int[] inOrder, int postStart, int postEnd, int[] postOrder, Map<Integer, Integer> inMap) {

        if (inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postOrder[postEnd]);
        Integer inRootPos = inMap.get(root.val);

        Integer numsToLeft = inRootPos - inStart;

        root.left = construct(inStart, inRootPos - 1, inOrder, postStart, postStart + numsToLeft-1, postOrder, inMap);
        root.right = construct(inRootPos + 1, inEnd, inOrder, numsToLeft, postEnd-1, postOrder, inMap);

        return root;
    }

    public TreeNode constructTree(int[] postOrder, int[] inOrder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(postOrder[i], i);
        }

        TreeNode root = construct(0, inOrder.length - 1, inOrder, 0, postOrder.length - 1, postOrder, inMap);
        return root;
    }

    public static void main(String[] args) {
        ConstructTreeFromInAndPost bt =new ConstructTreeFromInAndPost();
        int[] inOrder = {40,20,50,10,60,30};
        int[] postOrder = {40,50,20,60,30,10};

        TreeNode root = bt.constructTree(postOrder,inOrder);
        PostOrderTraversal traversal = new PostOrderTraversal();
        traversal.traversal(root);
    }

}
