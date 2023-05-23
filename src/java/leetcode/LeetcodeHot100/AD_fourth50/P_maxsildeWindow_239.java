package leetcode.LeetcodeHot100.AD_fourth50;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_maxsildeWindow_239 {

    public static void main(String[] args) {
        P_maxsildeWindow_239 solution = new P_maxsildeWindow_239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }

    // https://leetcode.cn/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
    // https://leetcode.cn/submissions/detail/402839779/
    public int[] maxSlidingWindow(int[] nums, int windowLen) {
        int len = nums.length;
        return new int[len - windowLen + 1];
    }

}
