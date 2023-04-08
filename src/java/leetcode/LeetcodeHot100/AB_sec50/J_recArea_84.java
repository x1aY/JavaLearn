package leetcode.LeetcodeHot100.AB_sec50;

import java.util.ArrayDeque;
import java.util.Deque;

public class J_recArea_84 {

    public static void main(String[] args) {
        J_recArea_84 ans = new J_recArea_84();
        int[] heights = new int[] { 2, 1, 5, 6, 2, 3 };
        ans.largestRectangleArea(heights);
    }

    public int largestRectangleArea(int[] heights) {
        int ans = 0, len = heights.length;
        int[] hList = new int[len + 2];
        hList[0] = 0;
        hList[len + 1] = 0;
        for (int i = 0; i < len; i++)
            hList[i + 1] = heights[i];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len + 2; i++) {
            while (!stack.isEmpty() && hList[stack.peek()] > hList[i]) {
                int h = hList[stack.pop()];
                int lIdx = stack.peek();
                int w = i - lIdx - 1;
                ans = Math.max(ans, w * h);
            }
            stack.push(i);
        }
        return ans;
    }

}
