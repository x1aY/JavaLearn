package leetcode.Labuladong.B_BinaryTree.A_creed;

import leetcode.Labuladong.laCommon.TreeNode;

public class B_diameterOfBinaryTree_543 {

    public int maxDoubleDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        CurrDiameter(root);
        return maxDoubleDiameter == 0 ? 0 : maxDoubleDiameter - 1;
    }

    public int CurrDiameter(TreeNode currNode) {
        int currDiameter = 0, leftDiameter = 0, rightDiameter = 0;
        if (currNode != null) {
            if (currNode.left != null)
                leftDiameter = CurrDiameter(currNode.left);
            if (currNode.right != null)
                rightDiameter = CurrDiameter(currNode.right);
            currDiameter = Math.max(leftDiameter, rightDiameter) + 1;
            maxDoubleDiameter = Math.max(maxDoubleDiameter, leftDiameter + rightDiameter + 1);
        }
        return currDiameter;
    }

    public static void main(String[] args) {
        int[] valLayer = { 1, 2, 3,
                4, 5, TreeNode.LEEF, TreeNode.LEEF };
        // int[] valLayer = { 1, 2, 3,
        // 4, 5, TreeNode.LEEF, TreeNode.LEEF,
        // 6, TreeNode.LEEF, TreeNode.LEEF, 7,
        // TreeNode.LEEF, TreeNode.LEEF, TreeNode.LEEF, TreeNode.LEEF, };
        TreeNode root = TreeNode.GenBTree(valLayer);
        System.out.println(new B_diameterOfBinaryTree_543().diameterOfBinaryTree(root));
    }

}