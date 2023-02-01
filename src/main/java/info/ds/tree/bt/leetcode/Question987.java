package info.ds.tree.bt.leetcode;

import java.util.*;

/**
 * Vertical Order Traversal
 */
public class Question987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        if (root == null) {
            return result;
        }

        traverse(root, 0, 0, map);

        for (Map.Entry<Integer, Map<Integer, PriorityQueue<Integer>>> entry : map.entrySet()) {
            List<Integer> verticalOrder = new ArrayList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> entry1 : entry.getValue().entrySet()) {
                PriorityQueue<Integer> q = entry1.getValue();
                while (!q.isEmpty()) {
                    verticalOrder.add(q.poll());
                }
            }
            result.add(verticalOrder);
        }

        return result;
    }

    public Map<Integer, Map<Integer, PriorityQueue<Integer>>> traverse(TreeNode node, int level, int vertical, Map<Integer, Map<Integer, PriorityQueue<Integer>>> map) {

        if (node == null) {
            return map;
        }

        map = storeInMap(map,node,level,vertical);

        traverse(node.left, level + 1, vertical - 1, map);
        traverse(node.right, level + 1, vertical + 1, map);

        return map;
    }

    public Map<Integer, Map<Integer, PriorityQueue<Integer>>> storeInMap(Map<Integer, Map<Integer, PriorityQueue<Integer>>> map, TreeNode node, int level, int vertical) {

        if (map.get(vertical) == null) {
            Map<Integer, PriorityQueue<Integer>> m = new TreeMap<>();
            PriorityQueue<Integer> q = new PriorityQueue();
            q.offer(node.val);
            m.put(level, q);
            map.put(vertical, m);

        } else if (map.get(vertical).get(level) == null) {
            Map<Integer, PriorityQueue<Integer>> m = map.get(vertical);
            PriorityQueue<Integer> q = m.get(level)==null?new PriorityQueue<>():m.get(level);
            q.offer(node.val);
            m.put(level, q);
            map.put(vertical, m);
        } else {
            map.get(vertical).get(level).offer(node.val);
        }


        return map;
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

       Question987 q = new Question987();
       q.verticalTraversal(node).forEach(i-> System.out.println(i.toString()));


    }
}
