package leetcode.CodeCaprice.AI_greedy.D_range;

import java.util.Arrays;

public class K_minArrowShots_452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int len = points.length, minArrow = len;
        if (len < 2) return len;
        int[] preRange = new int[] { points[0][0], points[0][1] };
        for (int i = 1; i < len; i++) {
            int[] currPoint = points[i];
            int[] commonPoint = findCommon(preRange, currPoint);
            if (commonPoint == null)
                preRange = new int[] { currPoint[0], currPoint[1] };
            else {
                preRange = commonPoint;
                minArrow--;
            }
        }
        return minArrow;
    }

    public int[] findCommon(int[] point1, int[] point2) {
        int commonX = point1[0] > point2[0] ? point1[0] : point2[0],
                commonY = point1[1] < point2[1] ? point1[1] : point2[1];
        return commonX > commonY ? null : new int[] { commonX, commonY };
    }

    public static void main(String[] args) {
        K_minArrowShots_452 solution = new K_minArrowShots_452();
        int[][] points = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        System.out.println(solution.findMinArrowShots(points));
    }

}
