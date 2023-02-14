package info.ds.tree.bst;

import info.ds.tree.bt.leetcode.TreeNode;


/**
 * Hint : Threaded BT
 * Since we are doing Moris traversal , TC - > O(n) and SC - > O(1)
 */
public class SearchElement {


    public boolean searchInBst(Integer key, TreeNode root) {


        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == key) return true;
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode temp = cur.left;
                while (temp.right != null && temp.right.val != cur.val) {
                    temp = temp.right;
                }

                if (temp.right != null && temp.right.val == cur.val) {
                    temp.right = null;
                    cur = cur.right;
                } else {
                    temp.right = cur;
                    cur = cur.left;
                }

            }
        }
        return false;
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

        SearchElement bst = new SearchElement();
        System.out.println(bst.searchInBst(14, node));


    }

}
