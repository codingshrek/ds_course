package info.ds.tree.bt;

import java.util.Stack;

public class InOrderTraversal {

    public void traversal(BinaryTree.Node root) {

        if (root == null) {
            return;
        }

        traversal(root.left);
        System.out.println(root.val);
        traversal(root.right);

    }

    public void iterativeTraversal(BinaryTree.Node root) {
        Stack<BinaryTree.Node> stack = new Stack<>();
        while(true){
            if(root!=null){
                stack.add(root);
                root=root.left;
            }
            else {
                if(stack.isEmpty()) break;
                BinaryTree.Node node = stack.pop();
                System.out.println(node);
                root=node.right;
            }
        }
    }

    public static void main(String args[]) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node root = tree.buildTree(nodes);

        InOrderTraversal traversal = new InOrderTraversal();
        traversal.traversal(root);
        System.out.println("------------");
        traversal.iterativeTraversal(root);
    }
}
