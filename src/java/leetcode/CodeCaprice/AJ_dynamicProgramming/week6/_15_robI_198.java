package leetcode.CodeCaprice.AJ_dynamicProgramming.week6;

public class _15_robI_198 {

    public int rob(int[] nums) {
        int itemLen = nums.length;
        if (itemLen < 2)
            return nums[0];
        int[] dp = new int[itemLen];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < itemLen; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[itemLen - 1];
    }

    public static void main(String[] args) {
        _15_robI_198 solution = new _15_robI_198();
        int[] nums = { 2, 7, 9, 3, 1 };
        solution.rob(nums);
    }

}
