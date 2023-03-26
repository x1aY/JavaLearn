package leetcode.Labuladong.G_dynamicPlanning.B_classic;

import java.util.Arrays;
import java.util.function.BiFunction;

public class D_maxCommonSub_1143 {

    int[][] dp;
    char[] arrayL, arrayR;

    public int mylongestCommonSubsequence(String text1, String text2) {
        arrayL = text1.toCharArray();
        arrayR = text2.toCharArray();
        int LLen = arrayL.length, RLen = arrayR.length;
        dp = new int[LLen][RLen];
        for (int[] dpi : dp) Arrays.fill(dpi, Integer.MIN_VALUE);
        return maxCommonSub(arrayL, arrayR, LLen - 1, RLen - 1);
    }

    public int maxCommonSub(char[] arrayL, char[] arrayR, int LIndex, int RIndex) {
        if (LIndex < 0 || RIndex < 0) return 0;
        if (arrayL[LIndex] == arrayR[RIndex]) return setDp.apply(LIndex - 1, RIndex - 1) + 1;
        return Math.max(setDp.apply(LIndex - 1, RIndex), setDp.apply(LIndex, RIndex - 1));
    }

    BiFunction<Integer, Integer, Integer> setDp = (LIndex, RIndex) -> {
        if (LIndex < 0 || RIndex < 0) return 0;
        dp[LIndex][RIndex] = dp[LIndex][RIndex] == Integer.MIN_VALUE ? 
                maxCommonSub(arrayL, arrayR, LIndex, RIndex): dp[LIndex][RIndex];
        return dp[LIndex][RIndex];
    };


    /* *
     * 更快，3倍
     */

    int[][] memo;

    /* 主函数 */
    int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo) 
            Arrays.fill(row, -1);
        // 计算 s1[0..] 和 s2[0..] 的 lcs 长度
        return dp(s1, 0, s2, 0);
    }

    // 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
    int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        // 如果之前计算过，则直接返回备忘录中的答案
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 根据 s1[i] 和 s2[j] 的情况做选择
        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 必然在 lcs 中
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中
            memo[i][j] = Math.max(
                dp(s1, i + 1, s2, j),
                dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }


    public static void main(String[] args) {
        D_maxCommonSub_1143 solution = new D_maxCommonSub_1143();
        String text1 = "abcde", text2 = "aced";
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }
}
