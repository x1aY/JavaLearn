package leetcode.LeetcodeHot100.AA_fst50;

public class AO_searchArray_33 {
    public static void main(String[] args) {
        AO_searchArray_33 solution = new AO_searchArray_33();
        int ans = solution.search(new int[] { 4,5,6,7,0,1,2 }, 3);
        System.out.println(ans);
    }

    public int search(int[] nums, int target) {
        return 0;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
