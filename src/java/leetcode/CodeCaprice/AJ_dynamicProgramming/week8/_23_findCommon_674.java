package leetcode.CodeCaprice.AJ_dynamicProgramming.week8;

public class _23_findCommon_674 {

    public int findLength(int[] fst, int[] sec) {
        int rows = fst.length, cols = sec.length, maxLen = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            if (sec[0] == fst[i]) {
                dp[i][0] = 1;
                maxLen = 1;
            }
        for (int i = 0; i < cols; i++)
            if (fst[0] == sec[i]) {
                dp[0][i] = 1;
                maxLen = 1;
            }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (fst[i] == sec[j])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        _23_findCommon_674 solution = new _23_findCommon_674();
        int[] nums1 = { 1, 2, 3, 2, 1 },
                nums2 = { 3, 2, 1, 4, 7 };
        solution.findLength(nums1, nums2);
    }

}
