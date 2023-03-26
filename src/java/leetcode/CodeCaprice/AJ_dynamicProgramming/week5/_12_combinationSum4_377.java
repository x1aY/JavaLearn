package leetcode.CodeCaprice.AJ_dynamicProgramming.week5;

public class _12_combinationSum4_377 {

    // https://leetcode.cn/problems/combination-sum-iv/solution/fu-xue-ming-zhu-cong-ji-yi-hua-di-gui-tu-rqwy/
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int sum = 1; sum <= target; sum++)
            for (int num : nums) {
                // 使用nums[index], 相当于把nums[index]放在最后，
                // 再将剩下的sum排列
                if (sum == num)
                    dp[sum] += 1;
                else if (sum >= num)
                    dp[sum] += dp[sum - num];
            }
        return dp[target];
    }

    public static void main(String[] args) {
        _12_combinationSum4_377 solution = new _12_combinationSum4_377();
        int[] nums = { 3, 1, 2, 4 };
        int target = 4;
        solution.combinationSum4(nums, target);
    }
}
