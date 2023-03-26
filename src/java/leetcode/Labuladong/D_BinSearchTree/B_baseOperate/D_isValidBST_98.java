package leetcode.Labuladong.D_BinSearchTree.B_baseOperate;

import leetcode.Labuladong.laCommon.TreeNode;

public class D_isValidBST_98 {
    public static boolean isValidBST(TreeNode root) {
        return true;
    }

    public static void main(String[] args) {
        int[] valLayer = { 5, 4, 6,
                TreeNode.LEEF, TreeNode.LEEF, 3, 7 };
        TreeNode root = TreeNode.GenBTree(valLayer);
        System.out.println(isValidBST(root));
    }
}
