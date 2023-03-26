package leetcode.LeetcodeHot100.singleMax;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class F_stockSpan_901 {

    public static void main(String[] args) {
        F_stockSpan_901 solution = new F_stockSpan_901();
        StockSpanner stockSpanner = solution.new StockSpanner();
        int[] inputs = new int[] { 100, 80, 60, 70, 60, 75, 85 };
        List<Integer> ans = new ArrayList<>();
        for (int input : inputs)
            ans.add(stockSpanner.next(input));
        System.out.println(ans.toString());
    }

    // https://leetcode.cn/problems/online-stock-span/solution/by-ac_oier-m8g7/
    class StockSpanner {

        Deque<Integer> stack;
        int preMax;

        public StockSpanner() {
            stack = new ArrayDeque<>();
        }

        public int next(int price) {
            int ans = 1;
            return ans;
        }
    }

}
