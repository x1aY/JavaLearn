package leetcode.Labuladong.A_DataStructure.E_binarySearch;

public class SearchRange_34 {
    public static int[] searchRange(int[] nums, int target) {
        int indexs[] = { -1, -1 };
        int numsLen = nums.length, left = 0, right = numsLen - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        if (numsLen > 0 && left < numsLen && nums[left] == target) {
            indexs[0] = left;
            right = left;
            while (right < numsLen && target == nums[right])
                right++;
            indexs[1] = right - 1;
        }
        return indexs;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2 };
        int target = 3;
        searchRange(nums, target);
    }
}
