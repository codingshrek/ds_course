package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;

import java.util.Stack;

public class BstInorderIterator {

    private Stack<TreeNode> asc;
    private Stack<TreeNode> dsc;
    private TreeNode root;

    public BstInorderIterator(TreeNode root) {
        asc = new Stack<>();
        dsc = new Stack<>();
        this.root = root;
        this.initializeStacks();

    }

    private void initializeStacks() {
        //initialize for preorder front.
        TreeNode temp = root;
        while (temp != null) {
            asc.push(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {
            dsc.push(temp);
            temp = temp.right;
        }
    }


    private void insertForFront(TreeNode node) {
        if (node.right != null) {
            TreeNode temp = node.right;
            while (temp != null) {
                this.asc.add(temp);
                temp = temp.left;
            }
        }
    }

    private void insertForBack(TreeNode node) {
        if (node.left != null) {
            TreeNode temp = node.left;
            while (temp != null) {
                this.dsc.push(temp);
                temp = temp.right;
            }
        }
    }

    public TreeNode next() {
        if (!asc.isEmpty()) {
            TreeNode node = this.asc.pop();
            insertForFront(node);
            return node;
        }
        return null;
    }

    public TreeNode prev() {
        if (!asc.isEmpty()) {
            TreeNode node = this.dsc.pop();
            insertForBack(node);
            return node;
        }
        return null;
    }

    public Boolean hasNext() {
        return !this.asc.isEmpty();
    }


    public Boolean hasPrev() {
        return !this.dsc.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(5);
        node.right = new TreeNode(13);

        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(14);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(6);
        node.left.left.left = new TreeNode(1);
        node.left.left.right = new TreeNode(2);

        BstInorderIterator iterator = new BstInorderIterator(node);

        System.out.println(iterator.next().val);
        System.out.println(iterator.next().val);
        System.out.println(iterator.next().val);

        System.out.println(iterator.prev().val);
        System.out.println(iterator.prev().val);
        System.out.println(iterator.prev().val);

    }

}
