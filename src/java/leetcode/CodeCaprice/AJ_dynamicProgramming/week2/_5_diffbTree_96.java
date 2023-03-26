package leetcode.CodeCaprice.AJ_dynamicProgramming.week2;

public class _5_diffbTree_96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 0; j <= (i - 1) / 2; j++)
                dp[i] += j == i - j - 1 ? 
                dp[j] * dp[i - j - 1] : 
                dp[j] * dp[i - j - 1] * 2;
        return dp[n];
    }

    public static void main(String[] args) {
        _5_diffbTree_96 solution = new _5_diffbTree_96();
        System.out.println(solution.numTrees(3));
    }

}
