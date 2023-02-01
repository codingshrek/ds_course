package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.*;

public class BottomView {

    public List<Integer> bottomView(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        //Vertical,TreeNode
        TreeMap<Integer, TreeNode> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(0, root);
        q.offer(p);

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair curPair = q.poll();
                int curVertical = curPair.vertical;
                TreeNode curNode = curPair.node;

                map.put(curVertical, curNode);

                if (curNode.left != null) {
                    Pair leftNode = new Pair(curVertical - 1, curNode.left);
                    q.offer(leftNode);
                }
                if (curNode.right != null) {
                    Pair rightNode = new Pair(curVertical + 1, curNode.right);
                    q.offer(rightNode);
                }

            }
        }

        for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
            result.add(entry.getValue().val);
        }

        return result;
    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        BottomView view = new BottomView();
        System.out.println(view.bottomView(node).toString());

    }

}
