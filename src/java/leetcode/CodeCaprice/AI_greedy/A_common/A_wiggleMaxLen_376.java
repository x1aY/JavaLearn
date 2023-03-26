package leetcode.CodeCaprice.AI_greedy.A_common;

import java.util.List;

public class A_wiggleMaxLen_376 {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        int wiggleLen = len;
        return wiggleLen;
    }

    public boolean isWiggle(List<Integer> nums) {
        int len = nums.size();
        if (len < 3)
            return true;
        for (int i = 0; i < len - 2; i++) {
            if ((nums.get(i + 2) - nums.get(i + 1))
                    * (nums.get(i + 1) - nums.get(i)) >= 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        A_wiggleMaxLen_376 solution = new A_wiggleMaxLen_376();
        int[] nums = { 1, 7, 4, 9, 2, 5 };
        System.out.println(solution.wiggleMaxLength(nums));
    }

    /**
     * https://leetcode.cn/problems/wiggle-subsequence/solution/bai-dong-xu-lie-by-leetcode-solution-yh2m/
     * 
     * 局部最优：删除单调坡度上的节点（不包括单调坡度两端的节点），那么这个坡度就可以有两个局部峰值。
     * 整体最优：整个序列有最多的局部峰值，从而达到最长摆动序列。
     */
    public int greedyWiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;
        int prevdiff = nums[1] - nums[0];
        int ret = (prevdiff == 0) ? 1 : 2;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }
}
