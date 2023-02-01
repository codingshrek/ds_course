package info.ds.tree.bt.leetcode;

import java.util.*;

/**
 * Zigzag traversal
 */
public class Question103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode node){
        if(node==null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> result = new LinkedList<>();
        queue.add(node);
        boolean flag = true;
        while(!queue.isEmpty()){
            int qSize = queue.size();
            List<Integer> levels = new LinkedList<>();
            for(int i=0;i<qSize;i++){
                TreeNode curNode = queue.poll();
                int index = flag?i:qSize-1-i;
                if(curNode.right!=null) queue.offer(curNode.right);
                if(curNode.left!=null) queue.offer(curNode.left);
                if(flag){
                    levels.add(index,curNode.val);
                }
                else{
                    levels.add(0,curNode.val);
                }
            }

            result.add(levels);
            flag = flag?false:true;
        }
        return result;
    }
}


