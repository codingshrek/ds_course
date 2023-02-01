package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxWidth {
    public Integer widthOfBinaryTree(TreeNode node) {
        if (node == null) return 0;
        Integer maxWidth = Integer.MIN_VALUE;
        Deque<PairIndex> q = new LinkedList<>();
        PairIndex root = new PairIndex(0, node);
        q.offerFirst(root);

        while (!q.isEmpty()) {

            int size = q.size();

            int min = q.peekFirst().index;
            Integer curLevelWidth = q.peekLast().index - q.peekFirst().index + 1;
            if (curLevelWidth > maxWidth) maxWidth = curLevelWidth;
            for (int i = 0; i < size; i++) {

                PairIndex curPair = q.pollFirst();
                Integer curIndex = curPair.index;
                Integer leftIndex = 2 * (curIndex - min) + 1;
                Integer rightIndex = 2 * (curIndex - min) + 2;

                if (curPair.node.left != null) {
                    PairIndex left = new PairIndex(leftIndex, curPair.node.left);
                    q.offerLast(left);
                }
                if (curPair.node.right != null) {
                    PairIndex right = new PairIndex(rightIndex, curPair.node.right);
                    q.offerLast(right);
                }
            }

        }
        return maxWidth;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        /*node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);*/

        /*node.left.left.left = new TreeNode(8);
        node.left.left.right = new TreeNode(9);

        node.left.right.left = new TreeNode(8);
        node.left.right.right = new TreeNode(9);*/

        MaxWidth w = new MaxWidth();
        System.out.println(w.widthOfBinaryTree(node));



    }

}

class PairIndex {

    public TreeNode node;
    public Integer index;

    public PairIndex(Integer index, TreeNode node) {
        this.node = node;
        this.index = index;
    }

}