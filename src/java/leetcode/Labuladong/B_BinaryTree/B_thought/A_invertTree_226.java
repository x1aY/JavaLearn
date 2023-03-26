package leetcode.Labuladong.B_BinaryTree.B_thought;

import leetcode.Labuladong.laCommon.TreeNode;

public class A_invertTree_226 {
    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode leftOri = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(leftOri);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] valLayer = { 4, 2, 7, 1, 3, 6, 9 };
        TreeNode root = TreeNode.GenBTree(valLayer);
        TreeNode reverseRoot = invertTree(root);
        System.out.println(reverseRoot.val);
    }
}
