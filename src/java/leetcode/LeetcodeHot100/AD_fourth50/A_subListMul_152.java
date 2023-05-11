package leetcode.LeetcodeHot100.AD_fourth50;

public class A_subListMul_152 {

    public static void main(String[] args) {
        A_subListMul_152 solution = new A_subListMul_152();
        System.out.println(solution.maxProduct(new int[]{7, -2, -4}));
    }

    public int maxProduct(int[] nums) {
        int maxAns = nums[0], len = nums.length;
        int[][] dp = new int[len][2];
        if (nums[0] > 0) {
            dp[0][0] = nums[0];
        } else if (nums[0] < 0) {
            dp[0][1] = nums[0];
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = nums[i] * dp[i - 1][1];
            } else if (nums[i] < 0) {
                dp[i][0] = nums[i] * dp[i - 1][1];
                dp[i][1] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
            }
            maxAns = Math.max(dp[i][0], maxAns);
        }
        return maxAns;
    }

}
