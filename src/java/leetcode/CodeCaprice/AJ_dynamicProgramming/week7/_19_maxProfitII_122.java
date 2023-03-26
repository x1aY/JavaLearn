package leetcode.CodeCaprice.AJ_dynamicProgramming.week7;

public class _19_maxProfitII_122 {

    public int maxProfit(int[] prices) {
        return 0;
    }

    public static void main(String[] args) {
        _18_maxProfitI_121 solution = new _18_maxProfitI_121();
        int[] prices = { 7,6,4,3,1 };
        solution.maxProfit(prices);
    }

    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
     * cash：持有现金，两种情况：
     *     1. 昨天持有现金，今天什么都不做；
     *     2. 昨天持股，今天卖出股票（现金数增加）
     * hold：持有股票，两种情况：
     *     1. 昨天持股，今天什么都不做（现金数与昨天一样）
     *     2. 昨天不持股，今天买入股票
     *  */ 
    public class Solution {

        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }
            int[] cash = new int[len], hold = new int[len];
            cash[0] = 0;
            hold[0] = -prices[0];
            
            for (int i = 1; i < len; i++) {
                // 这两行调换顺序也是可以的
                cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
                hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
            }
            return cash[len - 1];
        }
    }
}
