
package leetcode.CodeCaprice.AJ_dynamicProgramming.week4;

public class _8_targetSumWay_494 {

    public int findTargetSumWays(int[] nums, int target) {
        int itemLen = nums.length, sum = 0, maxWeight = 0;
        for (int num : nums)
            sum += num;
        if (sum + target < 0 || (sum + target) % 2 != 0)
            return 0;
        maxWeight = (sum + target) / 2;
        int[][] dp = new int[itemLen][maxWeight + 1];
        dp[0][0] = 1;
        if (nums[0] <= maxWeight) dp[0][nums[0]] += 1;
        for (int i = 1; i < itemLen; i++)
            for (int j = 0; j <= maxWeight; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i])
                    dp[i][j] += dp[i - 1][j - nums[i]];
            }
        return dp[itemLen - 1][maxWeight];
    }

    public static void main(String[] args) {
        _8_targetSumWay_494 solution = new _8_targetSumWay_494();
        // int[] nums = { 7, 0, 3, 9, 9, 9, 1, 7, 2, 3 };
        // int target = 6;
        int[] nums = { 100 };
        int target = -200;
        int res = solution.findTargetSumWays(nums, target);
        System.out.println(res);
    }

}
