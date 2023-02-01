package info.ds.tree.bt;

public class MaximumPathSum {


    public int maxiPathSum(BinaryTree.Node root) {
        int maxi[] = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxi);

        return maxi[0];
    }

    /**
     * @param root This method returns the maximum path from standing at a given node. Max can be either right or left.
     * @param maxi
     * @return
     */
    public int maxPathDown(BinaryTree.Node root, int[] maxi) {

        if (root == null) {
            return 0;
        }
        int leftSumMax = Math.max(0, maxPathDown(root.left, maxi)); // ignoring -vegetive sum thus using Math.max(0,f()) , becasue -ve sum will not give me max path.
        int rightSumMax = Math.max(0, maxPathDown(root.right, maxi));

        maxi[0] = Math.max(maxi[0], leftSumMax + rightSumMax + root.val); // storing maximum value

        return root.val + Math.max(leftSumMax, rightSumMax); //return maximum path
    }

    public static void main(String[] args) {
        //int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        int nodes[] = {-11, -2, -4, -1, -1, -5, -1, -1, -3, -1, -6, -1, -1};
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node root = tree.buildTree(nodes);

        MaximumPathSum maximumPathSum = new MaximumPathSum();
        System.out.println(maximumPathSum.maxiPathSum(root));
    }

}
