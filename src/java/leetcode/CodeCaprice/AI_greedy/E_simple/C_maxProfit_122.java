package leetcode.CodeCaprice.AI_greedy.E_simple;

public class C_maxProfit_122 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int minus = prices[i] - prices[i - 1];
            if (minus > 0)
                profit += minus;
        }
        return profit;
    }

    public static void main(String[] args) {
        C_maxProfit_122 solution = new C_maxProfit_122();
        int[] prices = { 7,6,4,3,1 };
        System.out.println(solution.maxProfit(prices));
    }
}