package info.ds.tree.bt;

public class DiameterOfATree {


   int max = 0;

    public int diameterOfBinaryTree(BinaryTree.Node root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(BinaryTree.Node root) {

        if(root==null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int maxHeight = Math.max(leftHeight,rightHeight)+1;
        int dim = leftHeight+rightHeight;

        if(dim>max){
            max = dim;
        }

        return maxHeight;
    }

    public static void main(String args[]) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node root = tree.buildTree(nodes);

        DiameterOfATree d = new DiameterOfATree();
        d.maxDepth(root);
        System.out.println(d.max);
    }

}
