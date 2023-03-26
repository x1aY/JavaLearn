package leetcode.Labuladong.F_DfsBfs.B_subSetArrangeCombine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G_subsets_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int numsLen = nums.length;
        backtrack(lists, new ArrayList<>(), nums, numsLen - 1);
        return lists;
    }

    public static void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int currIndex) {
        if (currIndex >= -1) lists.add(new ArrayList<>(list));
        if (currIndex < 0) return;
        for (int i = currIndex; i > -1; i--) {
            list.add(nums[i]);
            backtrack(lists, list, nums, i - 1);
            list.remove(list.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> lists = subsets(nums);

        if (lists != null)
            for (List<Integer> list : lists)
                System.out.println(list.toString());
    }

}
