package leetcode.Labuladong.F_DfsBfs.B_subSetArrangeCombine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F_permuteUnique_47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int numsLen = nums.length;
        boolean[] used = new boolean[numsLen];
        backtrack(lists, new ArrayList<>(), nums, used, numsLen, 0);
        return lists;
    }

    public static void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean[] used, int numsLen, int currLen) {
        if (currLen == numsLen) {
            lists.add(new ArrayList<>(list));
            return;
        }
        int preUsed = Integer.MIN_VALUE;
        for (int i = numsLen - 1; i > -1; i--) {
            if (!used[i] && nums[i] != preUsed) {
                used[i] = true;
                list.add(nums[i]);
                backtrack(lists, list, nums, used, numsLen, currLen + 1);
                list.remove(list.size()-1);
                used[i] = false;
                preUsed = nums[i];
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        List<List<Integer>> lists = permuteUnique(nums);
        if (lists != null)
            for (List<Integer> list : lists)
                System.out.println(list.toString());
    }
}
