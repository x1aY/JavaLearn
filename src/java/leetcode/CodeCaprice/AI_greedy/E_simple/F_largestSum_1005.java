package leetcode.CodeCaprice.AI_greedy.E_simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class F_largestSum_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        Collections.sort(list, (first, second) -> Math.abs(second) - Math.abs(first));
        int sum = 0, lastIndex = nums.length - 1;
        for (int i = 0; i <= lastIndex; i++) {
            int num = list.get(i);
            if (i == lastIndex && k > 0) {
                sum += (k % 2) == 0 ? num : -num;
            } else if (num < 0 && k > 0) {
                sum -= num;
                k--;
            } else
                sum += num;
        }
        return sum;
    }

    public int streamLargestSumAfterKNegations(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = Arrays.stream(nums).boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完
        if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();

    }

    public static void main(String[] args) {
        F_largestSum_1005 solution = new F_largestSum_1005();
        int[] nums = { 2, -3, -1, 5, -4 };
        int k = 2;
        System.out.println(solution.largestSumAfterKNegations(nums, k));
    }
}
