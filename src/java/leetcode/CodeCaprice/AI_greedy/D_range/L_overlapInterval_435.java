package leetcode.CodeCaprice.AI_greedy.D_range;

import java.util.Arrays;

public class L_overlapInterval_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if (len < 2)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int minErase = 0;
        int[] preInt = intervals[0];
        for (int i = 1; i < len; i++) {
            int[] currInt = intervals[i];
            if (preInt[1] > currInt[0]) {
                if (preInt[1] > currInt[1])
                    preInt = currInt;
                minErase++;
            } else
                preInt = currInt;
        }
        return minErase;
    }

    public boolean hasCommon(int[] point1, int[] point2) {
        return point1[1] > point2[0];
    }

    public static void main(String[] args) {
        L_overlapInterval_435 solution = new L_overlapInterval_435();
        int[][] intervals = { { -52, 31 }, { -73, -26 }, { 82, 97 }, { -65, -11 }, { -62, -49 }, { 95, 99 }, { 58, 95 },
                { -31, 49 }, { 66, 98 }, { -63, 2 }, { 30, 47 }, { -40, -26 } };
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }

}
