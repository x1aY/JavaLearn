package leetcode.Labuladong.F_DfsBfs.B_subSetArrangeCombine;

import java.util.ArrayList;
import java.util.List;

public class E_combine_77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), n, k);
        return lists;
    }

    public static void backtrack(List<List<Integer>> lists, List<Integer> list, int maxNum, int leftCount) {
        if (leftCount == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        // 一个剪枝，时间快10倍
        if(maxNum < leftCount) return;
        
        for (int i = maxNum; i > 0; i--) {
            list.add(i);
            backtrack(lists, list, i - 1, leftCount - 1);
            list.remove(Integer.valueOf(i));
        }
        return;
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> list = combine(n, k);
        if (list != null)
            for (List<Integer> listi : list)
                System.out.println(listi.toString());
    }
}
