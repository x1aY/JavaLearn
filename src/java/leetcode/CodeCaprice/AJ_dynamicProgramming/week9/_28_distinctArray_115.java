package leetcode.CodeCaprice.AJ_dynamicProgramming.week9;

public class _28_distinctArray_115 {

    public int numDistinct(String s, String t) {
        if (s.length() == 0)
            return 0;
        char[] fst = t.toCharArray(), sec = s.toCharArray();
        int rows = fst.length, cols = sec.length;
        int[][] dp = new int[rows][cols];
        if (fst[0] == sec[0]) dp[0][0] = 1;
        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1];
            if (fst[0] == sec[col])
                dp[0][col] += 1;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = dp[i][j - 1];
                if (fst[i] == sec[j])
                    dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        _28_distinctArray_115 solution = new _28_distinctArray_115();
        String s = "rabbbit", t = "rabbit";
        solution.numDistinct(s, t);
    }

}
