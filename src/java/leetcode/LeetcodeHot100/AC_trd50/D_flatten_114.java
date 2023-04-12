package leetcode.LeetcodeHot100.AC_trd50;

import leetcode.LeetcodeHot100.LcHotCommon.TreeNode;

public class D_flatten_114 {

    public static void main(String[] args) {
        D_flatten_114 ans = new D_flatten_114();
        int n = TreeNode.LEEF;
        TreeNode root = TreeNode.GenTree(new int[] { 1, 2, 5, 3, 4, n, 6 });
        ans.flatten(root);
        System.out.println(root.val);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right;
        flatten(left);
        flatten(right);
        if (left != null) {
            TreeNode leftEnd = left;
            while (leftEnd.right != null)
                leftEnd = leftEnd.right;
            leftEnd.right = right;
            root.right = left;
            root.left = null;
        }
        return;
    }

}
