package leetcode.LeetcodeHot100.AA_fst50;

public class AP_searchRange_34 {

    public static void main(String[] args) {
        AP_searchRange_34 solution = new AP_searchRange_34();
        solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
    }

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int res = binSearchBound(nums, 0, len - 1, target, true);
        return new int[] { res, binSearchBound(nums, res, len - 1, target, false) };
    }

    public int binSearchBound(int[] nums, int left, int right, int target, boolean isLeft) {
        if (left < 0 || right > nums.length) return -1;
        int res = -1, mid;
        while (right >= left) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                res = mid;
                if (isLeft)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return res;
    }

}
