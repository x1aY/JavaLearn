package leetcode.CodeCaprice.AI_greedy.A_common;

public class P_maxProfit_714 {

    public int maxProfit(int[] prices, int fee) {
        int maxProfit = 0;
        return maxProfit;
    }

    public static void main(String[] args) {
        P_maxProfit_714 solution = new P_maxProfit_714();
        int[] prices = { 1, 3, 2, 8, 7, 9 };
        int fee = 2;
        System.out.println(solution.maxProfit(prices, fee));
    }

    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-han-sh-rzlz/
     * 
     * 方法一中，我们将手续费放在卖出时进行计算。如果我们换一个角度考虑，将手续费放在买入时进行计算，那么就可以得到一种基于贪心的方法。
     * 我们用 buy表示在最大化收益的前提下，如果我们手上拥有一支股票，那么它的最低买入价格是多少。在初始时，buy的值为 prices[0]加上手续费fee。那么当我们遍历到第i(i >0)天时:
     *   如果当前的股票价格prices[i]加上手续费fee小于bug，那么与其使用buy的价格购买股票，我们不如以prices[i]+ fee的价格购买股票，因此我们将buy 更新为prices[司]+ fee;
     *   如果当前的股票价格prices[i]大于 bu，那么我们直接卖出股票并且获得prices[i]- buy的收益。但实际上，我们此时卖出股票可能并不是全局最优的（例如下一天股票价格继续上升)，因此我们可以提供一个反悔操作，看成当前手上拥有一支买入价格为prices[i]的股票，将buy更新为pricesi]。这样一来，如果下一天股票价格继续上升，我们会获得pricesi＋1]- pricesi]的收益，加上这一天prices[i] - buy的收益，恰好就等于在这一天不进行任何操作，而在下一天卖出股票的收益;
     *   对于其余的情况，prices[i]落在区间[buy - fee, bug]内，它的价格没有低到我们放弃手上的股票去选择它，也没有高到我们可以通过卖出获得收益，因此我们不进行任何操作。
     * 上面的贪心思想可以浓缩成一句话，即当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。在遍历完整个数组prices 之后之后，我们就得到了最大的总收益。
     */
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int buy = prices[0] + fee;
            int profit = 0;
            for (int i = 1; i < n; ++i) {
                if (prices[i] + fee < buy) {
                    buy = prices[i] + fee;
                } else if (prices[i] > buy) {
                    profit += prices[i] - buy;
                    buy = prices[i];
                }
            }
            return profit;
        }
    }
}
