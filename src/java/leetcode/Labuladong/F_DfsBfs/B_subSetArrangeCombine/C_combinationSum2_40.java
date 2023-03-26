package leetcode.Labuladong.F_DfsBfs.B_subSetArrangeCombine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C_combinationSum2_40 {
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int numsLen = nums.length;
        if (nums[0] > target) return lists;
        backtrack(lists, nums, numsLen, new ArrayList<>(), target, numsLen - 1);
        return lists;
    }

    public static void backtrack(List<List<Integer>> lists, int[] nums, int numsLen,
    List<Integer> currList, int currLeft, int currIndex) {
        if (currLeft == 0) {
            lists.add(new ArrayList<>(currList));
            return;
        }
        else if (currLeft < nums[0]) return;

        int preNum = 0;
        for (int i = currIndex; i > -1; i--) {
            if (currLeft >= nums[i] && nums[i] != preNum) {
                currList.add(nums[i]);
                backtrack(lists, nums, numsLen, currList, currLeft - nums[i], i - 1);
                currList.remove(Integer.valueOf(nums[i]));
                preNum = nums[i];
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        List<List<Integer>> list = combinationSum2(candidates, target);
        if (list != null)
            for (List<Integer> listi : list)
                System.out.println(listi.toString());
    }
}
