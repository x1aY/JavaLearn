package leetcode.LeetcodeHot100.singleMax;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class B_nextBigger_496 {

    public static void main(String[] args) {
        B_nextBigger_496 solution = new B_nextBigger_496();
        int[] nums1 = { 2, 4 }, nums2 = { 1, 2, 3, 4 };
        solution.nextGreaterElement(nums1, nums2);
    }

    public int[] nextGreaterElement(int[] sub, int[] list) {
        int subLen = sub.length;
        int[] ans = new int[subLen];
        Map<Integer, Integer> item2nextMax = new HashMap<>();

        Deque<Integer> stack = new ArrayDeque<>();
        for (int item : list) {
            while (!stack.isEmpty() && stack.peek() < item)
                item2nextMax.put(stack.pop(), item);
            stack.push(item);
        }
        for (int i = 0; i < subLen; i++)
            ans[i] = item2nextMax.getOrDefault(sub[i], -1);
        return ans;
    }

}
