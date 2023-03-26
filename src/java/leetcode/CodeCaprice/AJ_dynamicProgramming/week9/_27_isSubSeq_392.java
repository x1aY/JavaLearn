package leetcode.CodeCaprice.AJ_dynamicProgramming.week9;

public class _27_isSubSeq_392 {

    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        if(t.length()==0) return false;
        char[] fst = s.toCharArray(), sec = t.toCharArray();
        int rows = fst.length, cols = sec.length;
        boolean[][] dp = new boolean[rows][cols];
        for (int i = 1; i < rows; i++)
            dp[i][0] = false;
        for (int i = 0; i < cols; i++) {
            if (fst[0] == sec[i])
                while (i < cols)
                    dp[0][i++] = true;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (fst[i] == sec[j])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        _27_isSubSeq_392 solution = new _27_isSubSeq_392();
        String s = "axc", t = "ahbgdc";
        solution.isSubsequence(s, t);
    }

}
