package leetcode.LeetcodeHot100.AB_sec50;

public class A_maxSub_53 {

    public static void main(String[] args) {
        A_maxSub_53 solution = new A_maxSub_53();
        int[] nums = { 5,4,-1,7,8 };
        solution.maxSubArray(nums);
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length, ans = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
