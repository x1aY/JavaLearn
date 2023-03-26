package leetcode.CodeCaprice.AJ_dynamicProgramming.week9;

public class _26_maxSubArray_53 {

    // 选或者不选当前元素
    // 递推公式不好
    public int maxSubArray(int[] nums) {
        int len = nums.length, sum = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > dp[i - 1] && dp[i - 1] < 0)
                dp[i] = nums[i];
            else
                dp[i] = nums[i] + dp[i - 1];
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        _26_maxSubArray_53 solution = new _26_maxSubArray_53();
        int[] nums = { 5, 4, -1, 7, 8 };
        solution.maxSubArray(nums);
    }

}
