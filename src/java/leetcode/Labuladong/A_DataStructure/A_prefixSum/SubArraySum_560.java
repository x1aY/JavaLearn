package leetcode.Labuladong.A_DataStructure.A_prefixSum;
public class SubArraySum_560 {

    // 测试通过，特别慢
    // https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
    public static int MySubarraySumOld(int[] nums, int k) {
        int length = nums.length, count = 0;
        int[] subSumPre = new int[length + 1], subSumCurr = new int[length + 1];
        for (int len = 1; len < length + 1; len++) {
            for (int subIndex = len; subIndex < length + 1; subIndex++) {
                subSumCurr[subIndex] = nums[subIndex - 1] + subSumPre[subIndex - 1];
                subSumPre[subIndex - 1] = subSumCurr[subIndex - 1];
                if (subSumCurr[subIndex] == k)
                    count++;
            }
            subSumPre[length] = subSumCurr[length];
        }
        return count;
    }

    // 滑动窗口不行：数组可能为负数，无法让左指针移动
    public static int subarraySumSlidingWindow(int[] nums, int k) {
        int arrayLen = nums.length;
        int currSum = 0, left = 0, right = 0;
        int count = 0;
        while (right <= arrayLen && left <= right) {
            while (currSum >= k && left < arrayLen) {
                if (currSum == k && left != right)
                    count++;
                if (left < arrayLen)
                    currSum -= nums[left];
                left++;
            }
            if (right < arrayLen)
                currSum += nums[right];
            right++;
        }
        return count;
    }

    //https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
    /**
     * 关于mp.put(0, 1); 这一行的作用就是为了应对 nums[0] +nums[1] + ... + nums[i] == k 的情况的, 也就是从下标 0 累加到下标 i,;
     * 举个例子说明, 如数组 [1, 2, 3, 6], 那么这个数组的累加和数组为 [1, 3, 6, 12] 如果 k = 6,;
     * 假如map中没有预先 put 一个 (0, 1) , 如果此时我们来到了累加和为 6 的位置, 这时map中的情况是 (1, 1), (3, 1), 而 mp.containsKey(pre - k) , 这时 pre - k 也就是 6 - 6 = 0, 因为 map 中没有 (0, 1) 所以 count 的值没有加一;
     * 其实这个时候我们就是忽略了从下标 0 累加到下标 i 等于 k 的情况, 我们仅仅是统计了从下标大于 0 到某个位置等于 k 的所有答案。
     * 至于为什么是 count += mp.get(pre - k) ?
     *  举个例子: k = 6, 数组 [1, 2, 3, 0, 6] 累加和为: [1, 3, 6, 6, 12], 明显答案应该是 4;
     * 当我们来到第一个累加和为 6 的位置上时, pre - k = 0, 也就是说从下标 0 到当前位置的累加和是一个答案;
     * 当来到第二个 6 的位置上时, 也就是说从下标 0 到当前位置的累加和是一个答案;
     *  而当来到 12 位置上时, pre - k = 6, 也就是说从累加和为 6 的子数组的后一个位置到当前位置也是满足条件的答案, 而累加和为 6 的子数组只有一个吗 ? 不 ! 这个例子中他有两个, 所以 count 是 加 mp.get(pre - k);, 而不是加 1,
     */
    public static int subarraySum(int[] nums, int k) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { -1, -1, 1 };
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }

}
