package leetcode.CodeCaprice.AJ_dynamicProgramming.week11;

public class _33_rolls2Target_1155 {

    public int numRollsToTarget(int n, int k, int target) {
        int mod = (int) (Math.pow(10, 9) + 7);
        int[][] dp = new int[n][target + 1];
        for (int i = 1; i <= k && i <= target; i++)
            dp[0][i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= target; j++) {
                for (int numi = 1; numi < j && numi <= k; numi++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - numi]) % mod;
                }
            }
        }
        return dp[n - 1][target] % mod;
    }

    public static void main(String[] args) {
        _33_rolls2Target_1155 solution = new _33_rolls2Target_1155();
        int n = 2, k = 6, target = 7;
        solution.numRollsToTarget(n, k, target);
    }
}
