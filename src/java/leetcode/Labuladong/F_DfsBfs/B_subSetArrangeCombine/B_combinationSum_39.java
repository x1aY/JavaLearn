package leetcode.Labuladong.F_DfsBfs.B_subSetArrangeCombine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_combinationSum_39 {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int numsLen = nums.length;
        if (nums[0] > target)
            return lists;
        backtrack(lists, nums, numsLen, new ArrayList<>(), target, nums[numsLen - 1]);
        return lists;
    }

    public static void backtrack(List<List<Integer>> lists, int[] nums, int numsLen, List<Integer> currList, int currLeft, int preNum) {
        if (currLeft == 0) {
            lists.add(new ArrayList<>(currList));
            return;
        } else if (currLeft < nums[0]) {
            return;
        }
        for (int i = numsLen - 1; i > -1; i--) {
            if (preNum >= nums[i] && currLeft >= nums[i]) {
                currList.add(nums[i]);
                backtrack(lists, nums, numsLen, currList, currLeft - nums[i], nums[i]);
                currList.remove(Integer.valueOf(nums[i]));
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] candidates = { 2 };
        int target = 1;
        List<List<Integer>> list = combinationSum(candidates, target);
        if (list != null)
            for (List<Integer> listi : list)
                System.out.println(listi.toString());
    }
}
