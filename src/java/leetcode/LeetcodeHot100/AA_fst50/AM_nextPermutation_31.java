package leetcode.LeetcodeHot100.AA_fst50;

import java.util.Arrays;

public class AM_nextPermutation_31 {

    public static void main(String[] args) {
        AM_nextPermutation_31 solution = new AM_nextPermutation_31();
        int[] nums = { 2, 3, 1 };
        solution.nextPermutation(nums);
        System.out.println(nums.toString());
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length, chgIdx = -1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1])
                chgIdx = i - 1;
        }
        if (chgIdx != -1) {
            int minIdx = chgIdx + 1, minVal;
            for (int i = chgIdx + 2; i < len; i++)
                if (nums[i] > nums[chgIdx] && nums[i] < nums[minIdx])
                    minIdx = i;
            minVal = nums[minIdx];
            nums[minIdx] = nums[chgIdx];
            nums[chgIdx] = minVal;
            Arrays.sort(nums, chgIdx + 1, len);
        } else
            Arrays.sort(nums);
        return;
    }
}
