package leetcode.LeetcodeHot100.AA_fst50;

public class AN_longestVaild_32 {

    public static void main(String[] args) {
        AN_longestVaild_32 solution = new AN_longestVaild_32();
        solution.longestValidParentheses("(()())");
    }

    // https://leetcode.cn/problems/longest-valid-parentheses/solution/shou-hua-tu-jie-zhan-de-xiang-xi-si-lu-by-hyj8/
    // https://leetcode.cn/problems/longest-valid-parentheses/solution/zhan-zui-jian-jie-yi-dong-de-dai-ma-cjav-xa7v/
    // 超时

    public int longestValidParentheses(String s) {
        char rc = ')';
        int len = s.length(), maxLen = 0;
        if (len == 0)
            return 0;
        char[] data = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = false;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j += 2) {
                if (data[i] == rc || data[i] == data[j])
                    dp[i][j] = false;
                else if (i + 1 == j || dp[i + 1][j - 1] == true)
                    dp[i][j] = true;
                else {
                    for (int k = i + 1; k < j; k++)
                        if (dp[i][k] && dp[k + 1][j]) {
                            dp[i][j] = true;
                            break;
                        }
                }
                if (dp[i][j] == true)
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    // https://leetcode.cn/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
    // 我们只需要看从0到当前位置的有效括号长度就行了，没必要从i到j，因为判断有效括号长度时只需要依赖当前位置前面的字符，不需要依赖其后的，所以1维就行了。我理解判断当前状态只需要往前看时就不需要2维
    class solution {

        int longestValidParentheses(String s) {
            int n = s.length();
            char[] data = s.toCharArray();
            int[] dp = new int[n];

            int big = 0;
            for (int i = 1; i < n; i++) {
                if (data[i] == ')') {
                    if (data[i - 1] == '(') {
                        dp[i] = 2;
                        if (i - 2 >= 0)
                            dp[i] = dp[i] + dp[i - 2];
                    } else if (dp[i - 1] > 0) {
                        int lastSingleIndex = i - dp[i - 1] - 1;
                        if (lastSingleIndex >= 0 && data[lastSingleIndex] == '(') {
                            dp[i] = dp[i - 1] + 2;
                            if (lastSingleIndex - 1 >= 0) {
                                dp[i] = dp[i] + dp[lastSingleIndex - 1];
                            }
                        }
                    }
                }
                big = Math.max(big, dp[i]);
            }
            return big;
        }
    }
}