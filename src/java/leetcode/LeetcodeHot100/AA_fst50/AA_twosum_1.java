package leetcode.LeetcodeHot100.AA_fst50;
import java.util.HashMap;
import java.util.Map;

public class AA_twosum_1 {

    public static void main(String[] args) {
        AA_twosum_1 solution = new AA_twosum_1();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        solution.twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> num2idx = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i], left = target - num;
            if (num2idx.containsKey(left)) {
                int[] res = { num2idx.get(left), i };
                return res;
            }
            num2idx.put(num, i);
        }
        return null;
    }

}