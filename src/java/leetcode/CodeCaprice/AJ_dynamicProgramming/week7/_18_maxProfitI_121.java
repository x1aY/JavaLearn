package leetcode.CodeCaprice.AJ_dynamicProgramming.week7;

public class _18_maxProfitI_121 {

    public int maxProfit(int[] prices) {
        int profit = Integer.MIN_VALUE, minPrice = prices[0];
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        _18_maxProfitI_121 solution = new _18_maxProfitI_121();
        int[] prices = { 7,6,4,3,1 };
        solution.maxProfit(prices);
    }
}
