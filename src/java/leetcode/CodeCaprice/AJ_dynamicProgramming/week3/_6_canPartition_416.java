package leetcode.CodeCaprice.AJ_dynamicProgramming.week3;

public class _6_canPartition_416 {

    public boolean canPartition(int[] nums) {
        int sum = 0, itemLen = nums.length;
        for (int num : nums) sum += num;
        if (itemLen < 2 || sum % 2 != 0) return false;
        int maxWeight = sum / 2;
        boolean[][] dp = new boolean[itemLen][maxWeight + 1];
        if (nums[0] <= maxWeight) dp[0][nums[0]] = true;
        for (int i = 0; i < itemLen; i++) dp[i][0] = true;
        
        for (int i = 1; i < itemLen; i++)
            for (int j = 1; j <= maxWeight; j++)
                dp[i][j] = j - nums[i] < 0 ? dp[i - 1][j] : dp[i - 1][j] || dp[i - 1][j - nums[i]];
        return dp[itemLen - 1][maxWeight];
    }

    public static void main(String[] args) {
        _6_canPartition_416 solution = new _6_canPartition_416();
        int[] nums = { 1, 2, 5, 2 };
        solution.canPartition(nums);
    }

}
