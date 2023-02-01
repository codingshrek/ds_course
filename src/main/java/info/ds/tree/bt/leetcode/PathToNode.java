package info.ds.tree.bt.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathToNode {
    public boolean found = false;
    public List<Integer> traverseToNode(TreeNode node, Integer target, List<Integer> path){


        if(node == null){
            return path;
        }
        if(node.val == target){
            path.add(node.val);
            found = true;
            return path;
        }


        if(!found){
            path.add(node.val);
            traverseToNode(node.left,target,path);
            //Since we are not adding null to path , after backtracking from leaf we are not going to remove anything
            //If solution is found , then do not remove the node.
            if( node.left!=null && !found) {path.remove(path.size()-1);}
            traverseToNode(node.right,target,path);
            if( node.right!=null && !found) {path.remove(path.size()-1);}
        }

        return path;

    }

    public List<Integer> printRootToNodePath(TreeNode node,Integer target){
        if(node == null ) return new ArrayList<>();

        return traverseToNode(node,target,new ArrayList<>());

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);

        PathToNode p = new PathToNode();
        System.out.println(p.printRootToNodePath(node,3).toString());

    }

}
