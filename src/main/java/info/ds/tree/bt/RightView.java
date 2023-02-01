package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RightView {
    private Map<Integer, TreeNode> traverse(int level, TreeNode node, Map<Integer, TreeNode> map) {
        if (node == null) {
            return map;
        }
        if (!map.containsKey(level)) {
            map.put(level, node);
        }


        traverse(level + 1, node.right, map);
        traverse(level + 1, node.left, map);

        return map;

    }


    public List<Integer> rightView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, TreeNode> map = new TreeMap<>();
        traverse(0,root,map);
        for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
            res.add(entry.getValue().val);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        RightView view = new RightView();
        System.out.println(view.rightView(node).toString());

    }

}
