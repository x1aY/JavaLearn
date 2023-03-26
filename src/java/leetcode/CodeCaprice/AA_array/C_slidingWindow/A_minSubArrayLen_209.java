package leetcode.CodeCaprice.AA_array.C_slidingWindow;

public class A_minSubArrayLen_209 {

    // 滑动窗口
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // 上面的更简洁
    public static int MyMinSubArrayLen(int target, int[] nums) {
        boolean flag = false;
        int subSum = nums[0];
        int left = 0, right = 1;
        int minLen = nums.length, len = nums.length;
        while (right <= len) {
            while (subSum >= target) {
                flag = true;
                if (right - left < minLen)
                    minLen = right - left;
                subSum -= nums[left++];
            }
            if (right < len)
                subSum += nums[right];
            right++;
        }
        return flag ? minLen : 0;
    }

    public static void main(String[] args) {
        int[] nums = { 2,3,1,2,4,3 };
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
