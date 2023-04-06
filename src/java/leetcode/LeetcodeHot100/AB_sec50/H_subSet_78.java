package leetcode.LeetcodeHot100.AB_sec50;

import java.util.ArrayList;
import java.util.List;

public class H_subSet_78 {

    public static void main(String[] args) {
        H_subSet_78 ans = new H_subSet_78();
        int[] nums = new int[] { 1, 2, 3 };
        ans.subsets(nums);
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, list);
        return ans;
    }

    public void backtrack(int[] nums, int currStart, List<Integer> list) {
        for (int i = currStart; i < nums.length; i++) {
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            backtrack(nums, i + 1, list);
            list.remove(Integer.valueOf(nums[i]));
        }
    }

}
