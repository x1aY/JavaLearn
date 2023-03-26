package leetcode.CodeCaprice.AJ_dynamicProgramming.week6;

import leetcode.CodeCaprice.A_codeCommon.TreeNode;

public class _17_robIII_337 {

    // https://leetcode.cn/problems/house-robber-iii/solution/shu-xing-dp-ru-men-wen-ti-by-liweiwei1419/
    public int rob(TreeNode root) {
        return 0;
    }

    public static void main(String[] args) {
        _17_robIII_337 solution = new _17_robIII_337();
        int LEEF = TreeNode.LEEF;
        int[] valLayer = { 3, 2, 3, LEEF, 3, LEEF, 1 };
        TreeNode root = TreeNode.GenBTree(valLayer);
        solution.rob(root);
    }

}
