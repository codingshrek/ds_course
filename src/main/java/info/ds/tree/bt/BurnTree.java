package info.ds.tree.bt;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.*;

public class BurnTree {
    public ParentAndTarget markParents(Integer target, TreeNode root) {
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
        return new ParentAndTarget(targetNode, parentPointers);
    }

    public Integer traverse(TreeNode start, Map<Integer, TreeNode> parents, Set<Integer> visited) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(start);
        int timeToBurn = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {

                TreeNode curNode = q.poll();
                visited.add(curNode.val);
                TreeNode parentNode = parents.get(curNode.val);

                if (parentNode != null && !visited.contains(parentNode.val)) {
                    q.offer(parentNode);
                    flag = true;
                }
                if (curNode.left != null && !visited.contains(curNode.left.val)) {
                    q.offer(curNode.left);
                    flag = true;
                }
                if (curNode.right != null && !visited.contains(curNode.right.val)) {
                    q.offer(curNode.right);
                    flag = true;
                }

            }
            if (flag) timeToBurn++;
        }
        return timeToBurn;
    }

    public Integer minTimeTakeToBurn(Integer target, TreeNode root) {

        ParentAndTarget parents = markParents(target, root);
        Map<Integer, TreeNode> parentPointers = parents.parents;
        TreeNode startNode = parents.target;

        if (root == null) return 0;
        return traverse(startNode, parentPointers, new HashSet<>());
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
        node.left.right.left = new TreeNode(4);

        BurnTree b = new BurnTree();
        System.out.println(b.minTimeTakeToBurn(2, node));
    }

}

class ParentAndTarget {

    public TreeNode target;
    public Map<Integer, TreeNode> parents;

    public ParentAndTarget(TreeNode target, Map<Integer, TreeNode> parents) {
        this.target = target;
        this.parents = parents;
    }
}
