package leetcode.LeetcodeHot100.singleMax;

import java.util.ArrayDeque;
import java.util.Deque;

public class E_unsortSub_581 {

    public static void main(String[] args) {
        E_unsortSub_581 solution = new E_unsortSub_581();
        int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
        solution.findUnsortedSubarray(nums);
    }
    // https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/solution/gong-shui-san-xie-yi-ti-shuang-jie-shuan-e1le/
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int start = len, end = len;
        return end - start;
    }

    class Solution {
        public int findUnsortedSubarray(int[] nums) {
             //5,6,4,7,8.15,9,10,11  这样的话，整个数组都需要进行排序
            //使用单调栈来确定start和end
            Deque<Integer> stack = new ArrayDeque<>();
            int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
            for(int i=0; i<nums.length; i++){
                while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                    start = Math.min(start, stack.pop());
                }
                stack.push(i);
            }
            stack = new ArrayDeque<>();
            for(int i=nums.length-1; i>=0; i--){
                while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                    end = Math.max(end, stack.pop());
                }
                stack.push(i);
            }
            return start>end ? 0 : end-start+1;
        }
    }

}