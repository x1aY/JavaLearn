package leetcode.LeetcodeHot100.AB_sec50;

public class F_sortColors_75 {

    public static void main(String[] args) {
        F_sortColors_75 ans = new F_sortColors_75();
        int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
        ans.sortColors(nums);
    }

    // https://leetcode.cn/problems/sort-colors/solution/kuai-su-pai-xu-partition-guo-cheng-she-ji-xun-huan/
    public void sortColors(int[] nums) {
    }

    public void swap(int[] nums, int fstIdx, int secIdx) {
        int temp = nums[fstIdx];
        nums[fstIdx] = nums[secIdx];
        nums[secIdx] = temp;
    }
}
