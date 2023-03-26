package leetcode.LeetcodeHot100.range;

public class E_minSubArray_209 {

    public static void main(String[] args) {
        E_minSubArray_209 solution = new E_minSubArray_209();
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        solution.minSubArrayLen(target, nums);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0, right = 0, currSum = 0, minLen = Integer.MAX_VALUE;
        while (right < len) {
            currSum += nums[right++];
            while (currSum >= target) {
                minLen = Math.min(minLen, right - left);
                currSum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
