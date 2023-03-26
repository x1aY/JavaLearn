package leetcode.CodeCaprice.AJ_dynamicProgramming.week11;

public class _34_profitScheme_879 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profits) {
        return 0;
    }

    public static void main(String[] args) {
        _34_profitScheme_879 solution = new _34_profitScheme_879();
        int n = 10, minProfit = 5;
        int[] group = { 2, 3, 5 }, profits = { 6, 7, 8 };
        solution.profitableSchemes(n, minProfit, group, profits);
    }

    class solution{

        public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
            // len 工作的数量
            int len = group.length, MOD = (int)1e9 + 7;
            // dp[i][j][k]：前 i 个工作中选择了 j 个员工，并且满足工作利润至少为 k 的情况下盈利计划的总数目
            int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
            // 初始化，员工为 0，选择了 0 个员工，工作利润为 0
            // 即什么都不做，方案数为 1
            dp[0][0][0] = 1;
            for (int i = 1; i <= len; i++) {
                // 第 i 份工作需要使用的人数
                int members = group[i - 1];
                // 第 i 份工作能获取的利润
                int earn = profit[i - 1];
                for (int j = 0; j <= n; j++) {
                    for (int k = 0; k <= minProfit; k++) {
                        if (j < members) {
                            // 当前能提供的人工数量小于工作需要的人数，无法做该工作
                            dp[i][j][k] = dp[i - 1][j][k];
                        } else {
                            // 当人能提供的人工数量满足工作需要的人数，可以做该工作
                            // 为什么是 Math.max(0, k - profit[i - 1])，k 表示当前需要的最小利润
                            // if (k >= profit[i - 1])，前 i-1 种工作中选择的利润至少要达到 k-profit[i-1]
                            // if (k < profit[i -1])，说明前 i - 1 中工作的利润只要 >= 0 即可
                            dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - members][Math.max(0, k - earn)]) % MOD;
                        }
                    }
                }
            }
            int sum = 0;
            for (int j = 0; j <= n; j++) {
                sum = (sum + dp[len][j][minProfit]) % MOD;
            }
            return sum;
        }

    }
}
