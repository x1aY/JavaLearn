package leetcode.LeetcodeHot100.AA_fst50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AQ_combineSum_39 {

    public static void main(String[] args) {
        AQ_combineSum_39 solution = new AQ_combineSum_39();
        solution.combinationSum(new int[] { 2, 3, 5 }, 8);
        // Solution solution2 = solution.new Solution();
        // solution2.combinationSum(new int[] { 2, 3, 5 }, 8);
    }

    List<List<Integer>> ans;

    // int[] 元素非对象，只能获得升序而无法逆序
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, candidates.length, target, new ArrayList<>());
        return ans;
    }

    // 理解顺序遍历和逆序遍历的区别
    public void backtrack(int[] candidates, int startIdx, int length, int targetLeft, List<Integer> oneAns) {
        if (targetLeft == 0) {
            ans.add(new ArrayList<>(oneAns));
            return;
        } else if (targetLeft < candidates[startIdx])
            return;
        for (int i = startIdx; i < length; i++) {
            for (int j = 1; j * candidates[i] <= targetLeft; j++) {
                int candidate = j * candidates[i];
                for (int k = 0; k < j; k++)
                    oneAns.add(candidates[i]);
                backtrack(candidates, i + 1, length, targetLeft - candidate, oneAns);
                int lastIdx = oneAns.size() - 1;
                for (int k = 0; k < j; k++)
                    oneAns.remove(lastIdx--);
            }
        }
        return;
    }

    class Solution {
        public List<List<Integer>> combinationSum(int[] nums, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(nums);
            int numsLen = nums.length;
            if (nums[0] > target)
                return lists;
            backtrack(lists, nums, numsLen, new ArrayList<>(), target, nums[numsLen - 1]);
            return lists;
        }

        public void backtrack(List<List<Integer>> lists, int[] nums, int numsLen, List<Integer> currList, int currLeft,
                int preNum) {
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
    }
}
