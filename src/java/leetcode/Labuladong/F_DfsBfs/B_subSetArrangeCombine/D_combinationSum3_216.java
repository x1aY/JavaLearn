package leetcode.Labuladong.F_DfsBfs.B_subSetArrangeCombine;

import java.util.ArrayList;
import java.util.List;

public class D_combinationSum3_216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), k, n, 10);
        return lists;
    }

    public static void backtrack(List<List<Integer>> lists, List<Integer> list, int leftCount, int leftSum, int lastNum) {
        if (leftCount == 0) {
            if (leftSum == 0)
                lists.add(new ArrayList<>(list));
            return;
        }
        if (leftSum == 0) return;
        for (int i = lastNum - 1; i > 0; i--) {
            if (leftSum >= i) {
                list.add(i);
                backtrack(lists, list, leftCount - 1, leftSum - i, i);
                list.remove(Integer.valueOf(i));
            }
        }
        return;
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        List<List<Integer>> list = combinationSum3(k, n);
        if (list != null)
            for (List<Integer> listi : list)
                System.out.println(listi.toString());
    }
}
