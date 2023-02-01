package info.ds.tree.bt;

public class BalancedTree {


    public boolean balancedTree(BinaryTree.Node root){
        return maxDepth(root)!=-1;
    }

    public int maxDepth(BinaryTree.Node root) {

        if(root==null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        if(leftHeight ==-1) return -1;
        int rightHeight = maxDepth(root.right);
        if(rightHeight == -1) return -1;
        if(Math.abs(leftHeight-rightHeight)>1) return -1;

        int maxHeight = Math.max(leftHeight,rightHeight)+1;

        return maxHeight;
    }
}
