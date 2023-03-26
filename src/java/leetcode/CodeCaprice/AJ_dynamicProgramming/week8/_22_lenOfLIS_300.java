package leetcode.CodeCaprice.AJ_dynamicProgramming.week8;

import java.util.Arrays;

public class _22_lenOfLIS_300 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length, maxLen = 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        _22_lenOfLIS_300 solution = new _22_lenOfLIS_300();
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        solution.lengthOfLIS(nums);
    }

}
