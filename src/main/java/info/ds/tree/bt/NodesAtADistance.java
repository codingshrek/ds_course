package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.*;

/**
 * Try this using Moris Traversal.
 */
public class NodesAtADistance {

    public List<Integer> traverse(Integer k, TreeNode targetNode, Map<Integer, TreeNode> parentPointers, Set<Integer> visited, List<Integer> ds) {
        if (targetNode == null) {
            return ds;
        }


        if (!visited.contains(targetNode.val)) {
            if (k == 0) {
                ds.add(targetNode.val);
            }
            visited.add(targetNode.val);
            TreeNode parent = parentPointers.get(targetNode.val);
            if (parent != null) traverse(k - 1, parent, parentPointers, visited, ds); // Move upward;
            traverse(k - 1, targetNode.left, parentPointers, visited, ds); // Move to left child
            traverse(k - 1, targetNode.right, parentPointers, visited, ds); // Move to right child.
        }
        return ds;
    }

    public List<Integer> nodesAtADistance(Integer target, Integer k, TreeNode root) {

        Map<Integer, TreeNode> parentPointers = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode targetNode = null;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                if (curNode.val == target) targetNode = curNode;
                if (curNode.left != null) {
                    q.offer(curNode.left);
                    parentPointers.put(curNode.left.val, curNode);
                }
                if (curNode.right != null) {
                    q.offer(curNode.right);
                    parentPointers.put(curNode.right.val, curNode);
                }
            }
        }
        Set<Integer> visited = new HashSet<>();
        return traverse(k, targetNode, parentPointers, visited, new ArrayList<>());
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);

        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);

        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);

        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);

        NodesAtADistance nd = new NodesAtADistance();
        System.out.println(nd.nodesAtADistance(2, 3, node).toString());
    }
}
