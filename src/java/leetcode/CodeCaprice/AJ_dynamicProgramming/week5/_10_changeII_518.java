package leetcode.CodeCaprice.AJ_dynamicProgramming.week5;

public class _10_changeII_518 {

    public int changeII(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 不考虑顺序，组合数
        for (int coin : coins)
            for (int sum = coin; sum <= amount; sum++) {
                // 使用coin后剩下的组合
                dp[sum] += dp[sum - coin];
            }
        // 若考虑顺序/排列数，需要颠倒内外循环，此时会重复计算 dp[i][j - coins[i]]
        // for (int j = 0; j <= amount; j++) { // 遍历背包容量
        //     for (int i = 0; i < coins.length; i++) { // 遍历物品
        //         if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
        //     }
        // }
        return dp[amount];
    }

    public int change(int amount, int[] coins) {
        int itemLen = coins.length;
        int[][] dp = new int[itemLen][amount + 1];
        for (int i = 0; i < itemLen; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= amount; i++)
            dp[0][i] = (i % coins[0] == 0) ? 1 : 0;

        // 不考虑顺序，组合数
        // 若考虑顺序，排列数，需要颠倒内外循环，此时会重复计算 dp[i][j - coins[i]]
        for (int i = 1; i < itemLen; i++)
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i] >= 0)
                    dp[i][j] += dp[i][j - coins[i]];
            }
        return dp[itemLen - 1][amount];
    }

    public static void main(String[] args) {
        _10_changeII_518 solution = new _10_changeII_518();
        int amount = 5;
        int[] coins = { 1, 2, 5 };
        // int amount = 0;
        // int[] coins = { 7 };
        solution.changeII(amount, coins);
    }
}
