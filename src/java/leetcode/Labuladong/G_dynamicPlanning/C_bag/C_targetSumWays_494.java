package leetcode.Labuladong.G_dynamicPlanning.C_bag;

public class C_targetSumWays_494 {

    public int findTargetSumWays(int[] nums, int target) {
        int numsLen = nums.length;
        int[][] dp = new int[numsLen][target + 1];
        return dp[numsLen-1][target];
    }




    public static void main(String[] args) {
        C_targetSumWays_494 solution = new C_targetSumWays_494();
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(solution.findTargetSumWays(nums, target));
    }
}
