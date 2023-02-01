package info.ds.tree.bt;

public class MaximumDepth {
    public int maxDepth(BinaryTree.Node root) {

        if(root==null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int maxHeight = Math.max(leftHeight,rightHeight)+1;

        return maxHeight;
    }

}
