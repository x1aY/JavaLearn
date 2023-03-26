package leetcode.CodeCaprice.AI_greedy.D_range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_merge_56 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] preInt = new int[] { intervals[0][0], intervals[0][1] };
        for (int i = 1; i < len; i++) {
            int[] currInt = intervals[i];
            if (preInt[1] >= currInt[0]) {
                preInt[1] = Math.max(preInt[1], currInt[1]);
            } else {
                list.add(new int[] { preInt[0], preInt[1] });
                preInt = currInt;
            }
        }
        list.add(new int[] { preInt[0], preInt[1] });
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        N_merge_56 solution = new N_merge_56();
        int[][] intervals = { { 1, 4 }, { 4, 5 } };
        solution.merge(intervals);
    }
}
