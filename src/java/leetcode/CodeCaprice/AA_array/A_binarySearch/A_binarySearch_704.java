package leetcode.CodeCaprice.AA_array.A_binarySearch;

public class A_binarySearch_704 {
    public static int search(int[] nums, int target) {
        int mid = 0, left = 0, right = nums.length - 1;
        while (right >= left) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (right >= left) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target)
                right = mid - 1;
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = { -1,0,3,5,9,12 };
        int target = 2;
        System.out.println(search(nums, target));
    }
}
