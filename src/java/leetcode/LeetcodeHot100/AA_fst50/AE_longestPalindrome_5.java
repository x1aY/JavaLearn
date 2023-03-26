package leetcode.LeetcodeHot100.AA_fst50;
import leetcode.LeetcodeHot100.LcHotCommon.MyCommons;

public class AE_longestPalindrome_5 {

    public static void main(String[] args) {
        AE_longestPalindrome_5 solution = new AE_longestPalindrome_5();
        String s = "aacabdkacaa";
        solution.longestPalindrome(s);
    }

    // 写出题解时间过长
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        char[] chars = s.toCharArray();
        int len = chars.length;

        IDX[][] dp = new IDX[len][len];
        IDX maxLen = new IDX(0, 1);
        for (int i = 0; i < len; i++) dp[i][i] = new IDX(i, i + 1);

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 2 || dp[i + 1][j - 1] != null)
                        dp[i][j] = new IDX(i, j + 1);
                    if (dp[i][j] != null && maxLen.end - maxLen.st < dp[i][j].end - dp[i][j].st) {
                        maxLen.st = dp[i][j].st;
                        maxLen.end = dp[i][j].end;
                    }
                }
            }
        }
        MyCommons.print2Dim("%5s", "#", dp);
        return s.substring(maxLen.st, maxLen.end);
    }

    class IDX {
        public int st, end;

        public IDX(int st, int end) {
            this.st = st;
            this.end = end;
        }

        @Override
        public String toString() {
            return String.valueOf(st) + "," + String.valueOf(end);
        }
    }
}
