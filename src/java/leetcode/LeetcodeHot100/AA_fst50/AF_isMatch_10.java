package leetcode.LeetcodeHot100.AA_fst50;

public class AF_isMatch_10 {

    public static void main(String[] args) {
        AF_isMatch_10 solution = new AF_isMatch_10();
        // String data = "aab", patt = "c*a*b";
        // String data = "ab", patt = ".*c";
        String data = "aaa", patt = "aaaa";
        solution.isMatch(data, patt);
    }

    public boolean isMatch(String s, String p) {
        return true;
    }

    // https://leetcode.cn/problems/regular-expression-matching/solution/by-flix-musv/
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            boolean[][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;
            for (int i = 0; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];
                        if (matches(s, p, i, j - 1)) {
                            f[i][j] = f[i][j] || f[i - 1][j];
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
            return f[m][n];
        }

        public boolean matches(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }
}
