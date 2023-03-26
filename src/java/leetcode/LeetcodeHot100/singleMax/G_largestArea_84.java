package leetcode.LeetcodeHot100.singleMax;

import java.util.ArrayDeque;
import java.util.Deque;

public class G_largestArea_84 {

    public static void main(String[] args) {
        G_largestArea_84 solution = new G_largestArea_84();
        solution.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 });
    }

    // 视频 https://leetcode.cn/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        return maxArea;
    }

    // https://programmercarl.com/0084.%E6%9F%B1%E7%8A%B6%E5%9B%BE%E4%B8%AD%E6%9C%80%E5%A4%A7%E7%9A%84%E7%9F%A9%E5%BD%A2.html
    class Solution {
        int largestRectangleArea(int[] heights) {
            Deque<Integer> st = new ArrayDeque<>();
            
            // 数组扩容，在头和尾各加入一个元素
            int [] newHeights = new int[heights.length + 2];
            newHeights[0] = 0;
            newHeights[newHeights.length - 1] = 0;
            for (int index = 0; index < heights.length; index++){
                newHeights[index + 1] = heights[index];
            }
            heights = newHeights;

            int result = 0;
            // 第一个元素已经入栈，从下标1开始
            for (int i = 0; i < heights.length; i++) {
                // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
                if (heights[i] > heights[st.peek()]) {
                    st.push(i);
                } else if (heights[i] == heights[st.peek()]) {
                    st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                    st.push(i);
                } else {
                    while (heights[i] < heights[st.peek()]) { // 注意是while
                        int mid = st.peek();
                        st.pop();
                        int left = st.peek();
                        int right = i;
                        int w = right - left - 1;
                        int h = heights[mid];
                        result = Math.max(result, w * h);
                    }
                    st.push(i);
                }
            }
            return result;
        }
    }

}
