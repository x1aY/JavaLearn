package leetcode.LeetcodeHot100.subset;

import java.util.Arrays;

public class B_partitionKsub_698 {

    public static void main(String[] args) {
        B_partitionKsub_698 solution = new B_partitionKsub_698();
        solution.canPartitionKSubsets(new int[] { 3,3,10,2,6,5,10,6,8,3,2,1,6,10,7,2
            }, 6);
    }

    // https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/solution/zhua-wa-mou-si-by-muse-77-hytu/
    // https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/solution/by-ac_oier-mryw/
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length, sum = 0;
        for (int i = 0; i < len; i++)
            sum += nums[i];
        if (sum % k != 0)
            return false;
        sum /= k;
        Arrays.sort(nums);
        if (sum < nums[len - 1])
            return false;
        return false;
    }

}
