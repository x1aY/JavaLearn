package leetcode.Labuladong.G_dynamicPlanning.B_classic;

public class C_maxSubArray_53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] maxSub = new int[len];
        maxSub[0] = nums[0];
        for (int i = 1; i < len; i++) {
            maxSub[i] = Math.max(maxSub[i-1]+nums[i], nums[i]);
        }
        int maxInt = maxSub[0];
        for (int i : maxSub) if(maxInt<i) maxInt = i;
        return maxInt;
    }

    public static void main(String[] args) {
        C_maxSubArray_53 solution = new C_maxSubArray_53();
        int[] nums = { 1 };
        System.out.println(solution.maxSubArray(nums));
    }
}
