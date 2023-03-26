package leetcode.LeetcodeHot100.AB_sec50;

import java.util.Arrays;

public class D_mergeRange_56 {

    public static void main(String[] args) {
        D_mergeRange_56 solution = new D_mergeRange_56();
        int[][] intervals = new int[][] { { 1, 4 }, { 4, 5 }, { 8, 10 }, { 15, 18 } };
        solution.merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 遍历区间
        int[][] res = new int[len][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

}
