package leetcode.Labuladong.D_BinSearchTree.B_baseOperate;

import leetcode.Labuladong.laCommon.TreeNode;

public class B_insertBST_701 {
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode rootOri = root, rootPre = null,
                newNode = new TreeNode(val);
        if (root == null)
            return newNode;
        while (root != null) {
            rootPre = root;
            if (root.val > val)
                root = root.left;
            else
                root = root.right;
        }
        if (rootPre != null) {
            if (rootPre.val > val)
                rootPre.left = newNode;
            else
                rootPre.right = newNode;
        }
        return rootOri;
    }

    public static void main(String[] args) {
        int[] valLayer = { 4, 2, 7, 1, 3, 5, TreeNode.LEEF };
        TreeNode root = TreeNode.GenBTree(valLayer);
        TreeNode inRoot = insertIntoBST(root, 6);
        System.out.println(inRoot);
    }
}
