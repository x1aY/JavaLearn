package leetcode.LeetcodeHot100.nSum;

public class B_twoSum_167 {

    public static void main(String[] args) {
        B_twoSum_167 solution = new B_twoSum_167();
        int[] nums = { 12, 13, 23, 28, 43, 44, 59, 60, 61, 68, 70, 86, 88, 92, 124, 125, 136, 168, 173, 173, 180, 199,
                212, 221, 227, 230, 277, 282, 306, 314, 316, 321, 325, 328, 336, 337, 363, 365, 368, 370, 370, 371, 375,
                384, 387, 394, 400, 404, 414, 422, 422, 427, 430, 435, 457, 493, 506, 527, 531, 538, 541, 546, 568, 583,
                585, 587, 650, 652, 677, 691, 730, 737, 740, 751, 755, 764, 778, 783, 785, 789, 794, 803, 809, 815, 847,
                858, 863, 863, 874, 887, 896, 916, 920, 926, 927, 930, 933, 957, 981, 997 };
        int target = 542;
        solution.twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) i++;
            else if (sum > target) j--;
            else return new int[] { i + 1, j + 1 };
        }
        return new int[] { -1, -1 };
    }

    public int[] myTwoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left != right) {
            while (target < nums[left] + nums[right])
                right--;
            if (nums[left] + nums[right] == target)
                return new int[] { left + 1, right + 1 };
            left++;
        }
        return null;
    }

}
