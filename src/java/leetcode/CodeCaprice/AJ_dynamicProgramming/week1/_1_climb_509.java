package leetcode.CodeCaprice.AJ_dynamicProgramming.week1;

public class _1_climb_509 {

    public int climbStairs(int n) {
        if (n < 2) return n;
        int m = 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            for (int j = 1; j <= m; j++)
                dp[i] += (i - j >= 1) ? dp[i - j] : 0;
        return dp[n];
    }

    public static void main(String[] args) {
        _1_climb_509 solution = new _1_climb_509();
        int n = 1;
        System.out.println(solution.climbStairs(n));
    }

}