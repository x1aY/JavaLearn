package leetcode.LeetcodeHot100.AE_fifth50;

import java.util.Arrays;

public class A_numSquares_279 {

    public static void main(String[] args) {
        A_numSquares_279 solution = new A_numSquares_279();
        System.out.println(solution.numSquares(12));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int half = (int) Math.sqrt(i);
            if (half * half == i) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j < i / 2 + 1; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    // https://leetcode.cn/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1]; // 默认初始化值都为0
            for (int i = 1; i <= n; i++) {
                dp[i] = i; // 最坏的情况就是每次+1
                for (int j = 1; i - j * j >= 0; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
                }
            }
            return dp[n];
        }
    }
}
