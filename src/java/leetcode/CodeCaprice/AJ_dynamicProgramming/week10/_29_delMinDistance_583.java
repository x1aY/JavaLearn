package leetcode.CodeCaprice.AJ_dynamicProgramming.week10;

public class _29_delMinDistance_583 {

    public int minDistance(String word1, String word2) {
        char[] fst = word1.toCharArray(), sec = word2.toCharArray();
        int rows = fst.length, cols = sec.length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = fst[0] == sec[0] ? 0 : 2;
        for (int i = 1; i < cols; i++)
            dp[0][i] = (fst[0] == sec[i]) ? i : dp[0][i - 1] + 1;
        for (int i = 1; i < rows; i++)
            dp[i][0] = (fst[i] == sec[0]) ? i : dp[i - 1][0] + 1;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (fst[i] == sec[j])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        _29_delMinDistance_583 solution = new _29_delMinDistance_583();
        String fst = "sea", sec = "eat";
        solution.minDistance(fst, sec);
    }
}
