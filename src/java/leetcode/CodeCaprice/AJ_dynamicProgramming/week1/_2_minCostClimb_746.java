package leetcode.CodeCaprice.AJ_dynamicProgramming.week1;

public class _2_minCostClimb_746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++)
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        return dp[len];
    }

    public static void main(String[] args) {
        _2_minCostClimb_746 solution = new _2_minCostClimb_746();
        int[] cost = { 10, 15, 20 };
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
