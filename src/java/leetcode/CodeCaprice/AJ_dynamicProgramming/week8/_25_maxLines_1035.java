package leetcode.CodeCaprice.AJ_dynamicProgramming.week8;

public class _25_maxLines_1035 {

    // 不相交，则必然相对位置要一致，换句话说就是：公共子序列
    public int maxUncrossedLines(int[] fst, int[] sec) {
        int rows = fst.length, cols = sec.length, maxLine = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            if (sec[0] == fst[i]) {
                while (i < rows)
                    dp[i++][0] = 1;
                maxLine = 1;
            }
        for (int i = 0; i < cols; i++)
            if (fst[0] == sec[i]) {
                while (i < cols)
                    dp[0][i++] = 1;
                maxLine = 1;
            }
        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++) {
                if (fst[i] == sec[j])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                maxLine = Math.max(maxLine, dp[i][j]);
            }
        return maxLine;
    }

    public static void main(String[] args) {
        _25_maxLines_1035 solution = new _25_maxLines_1035();
        int[] nums1 = { 2, 5, 1, 2, 5 },
                nums2 = { 10, 5, 2, 1, 5, 2 };
        solution.maxUncrossedLines(nums1, nums2);
    }

}
