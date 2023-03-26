package leetcode.LeetcodeHot100.AA_fst50;

import java.util.Comparator;

public class AR_trap_42 {

    public static void main(String[] args) {
        AR_trap_42 solution = new AR_trap_42();
        solution.trap(new int[] { 4, 2, 0, 3, 2, 5 });
    }

    // https://programmercarl.com/0042.%E6%8E%A5%E9%9B%A8%E6%B0%B4.html#%E5%8D%95%E8%B0%83%E6%A0%88%E8%A7%A3%E6%B3%95
    // https://leetcode.cn/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
    // https://leetcode.cn/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode-solution-tuvc/
    // https://leetcode.cn/problems/trapping-rain-water/solution/trapping-rain-water-by-ikaruga/
    // 考虑思路不全
    public int trap(int[] height) {
        int len = height.length, ans = 0;
        Comparator<Integer> asc = (a, b) -> a - b;
        Comparator<Integer> desc = (a, b) -> b - a;
        int left = findEnd(height, len, 0, asc);
        if (left == len - 1)
            return ans;
        int descEnd, ascEnd;
        while (left < len - 1) {
            descEnd = findEnd(height, len, left, desc);
            ascEnd = findEnd(height, len, descEnd, asc);
            ans += computeArea(height, left, descEnd, ascEnd);
            left = ascEnd;
        }
        return ans;
    }

    public int findEnd(int[] height, int len, int start, Comparator<Integer> compare) {
        if (start == -1)
            return -1;
        int end = start;
        while (end + 1 < len && compare.compare(height[end], height[end + 1]) < 0)
            end++;
        return end;
    }

    public int computeArea(int[] height, int left, int middle, int right) {
        if (left == middle || middle == right)
            return 0;
        int minus = 0;
        for (int i = left + 1; i < right; i++)
            minus += height[i];
        return (right - left - 1) * (height[left] > height[right] ? height[right] : height[left]) - minus;
    }

}
