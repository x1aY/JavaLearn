package leetcode.LeetcodeHot100.AB_sec50;

public class C_canJumpII_45 {

    public static void main(String[] args) {
        C_canJumpII_45 solution = new C_canJumpII_45();
        int[] nums = { 2, 3, 0, 1, 4 };
        solution.jump(nums);
    }

    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                if (i - j <= nums[j])
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[len - 1];
    }

    class Solution {
        public int jump(int[] nums) {
            if(nums.length == 1) return 0;
            int reach = 0;
            int nextreach = nums[0];
            int step = 0;
            for(int i = 0;i<nums.length;i++){
                nextreach = Math.max(i+nums[i],nextreach);
                if(nextreach >= nums.length-1) return (step+1);
                if(i == reach){
                    step++;
                    reach = nextreach;
                }
            }
            return step;
        }
    }

}
