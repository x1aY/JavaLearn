package leetcode.CodeCaprice.AJ_dynamicProgramming.week5;

import java.util.Arrays;

public class _11_coinChange_322 {

    // 要求最少硬币数量，硬币是组合数还是排列数都无所谓
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int MAX_VALUE = (int) 2e9;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX_VALUE);
        for (int sum = 1; sum <= amount; sum++)
            for (int coin : coins) {
                if (sum == coin)
                    dp[sum] = 1;
                else if (sum > coin)
                    dp[sum] = Math.min(dp[sum], dp[sum - coin] + 1);
            }
        return dp[amount] >= MAX_VALUE ? -1 : dp[amount];
    }

    
    // 二维dp，初始化麻烦
    // 上一层的dp[i-1][j - coins[i]]也可能是无解的
    public int coinChangeI(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int itemLen = coins.length, MAX_VALUE = (int) 2e9;
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++)
            dp[i] = (i % coins[0] == 0) ? i / coins[0] : MAX_VALUE;

        for (int i = 1; i < itemLen; i++)
            // for (int j = 1; j <= amount; j++)
            // if (j - coins[i] >= 0)
            // dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            for (int j = coins[i]; j <= amount; j++)
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

        return dp[amount] >= MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        _11_coinChange_322 solution = new _11_coinChange_322();
        int amount = 27;
        int[] coins = { 2, 5, 10, 1 };
        int res = solution.coinChange(coins, amount);
        System.out.println(res);
    }
}
