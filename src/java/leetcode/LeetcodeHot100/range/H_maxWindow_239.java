package leetcode.LeetcodeHot100.range;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class H_maxWindow_239 {

    public static void main(String[] args) {
        H_maxWindow_239 solution = new H_maxWindow_239();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        solution.maxSlidingWindow(nums, k);
    }

    // 队列删除操作很耗时，尽量不删除元素
    // 和poll相比remove操作更耗时
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - (k - 1)];
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> b[1] - a[1]);
        int left = 0, right = 0, resIdx = 0;
        while (right < len) {
            pq.add(new int[] { right, nums[right++] });
            if (right - left >= k) {
                while (pq.peek()[0] < left)
                    pq.poll();
                res[resIdx++] = pq.peek()[1];
                left++;
            }
        }
        return res;
    }

    /*
     * https://leetcode.cn/problems/sliding-window-maximum/solution/by-ac_oier-o89l/
     * 
     *  假设我们当前处理到某个长度为 k 的窗口，此时窗口往后滑动一格，
     * 会导致后一个数（新窗口的右端点）添加进来，同时会导致前一个数（旧窗口的左端点）移出窗口
     * 
     * 随着窗口的不断平移，该过程会一直发生。若同一时刻存在两个数 nums[j] 和 nums[i]（j<i）所在一个窗口内，下标更大的数会被更晚移出窗口，
     * 此时如果有nums[j]<=nums[i] 的话，可以完全确定nums[j] 将不会成为后续任何一个窗口的最大值，此时可以将必然不会是答案的nums[j]
     * 从候选中进行移除
     * 
     * 不难发现，当我们将所有必然不可能作为答案的元素（即所有满足的小于等于 nums[i] ）移除后，候选集合满足「单调递减」特性，
     * 即集合首位元素为当前窗口中的最大值（为了满足窗口长度为 k 的要求，在从集合头部取答案时需要先将下标小于的等于的 i−k 的元素移除）
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 存储index
            Deque<Integer> d = new ArrayDeque<>();
            int n = nums.length, m = n - k + 1;
            int[] ans = new int[m];
            for (int i = 0; i < n; i++) {
                while (!d.isEmpty() && nums[d.peekLast()] <= nums[i])
                    d.pollLast();
                d.addLast(i);
                if (i >= k - 1) {
                    while (!d.isEmpty() && d.peekFirst() <= i - k)
                        d.pollFirst();
                    ans[i - k + 1] = nums[d.peekFirst()];
                }
            }
            return ans;
        }
    }

}
