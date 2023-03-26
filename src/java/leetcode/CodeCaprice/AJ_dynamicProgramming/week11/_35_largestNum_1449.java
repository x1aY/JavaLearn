package leetcode.CodeCaprice.AJ_dynamicProgramming.week11;

import java.util.Arrays;

public class _35_largestNum_1449 {
    public String largestNumber(int[] costs, int target) {
        int itemLen = 9;
        String[][] dp = new String[itemLen][target + 1];
        String cost0 = "1", preCost0 = "";
        Arrays.fill(dp[0], "");
        for (int i = 1, j = costs[0]; i * j <= target; i++) {
            dp[0][i * j] = cost0 + preCost0;
            preCost0 = dp[0][i * j];
        }
        for (int i = 1; i < itemLen; i++) {
            int costi = costs[i];
            String numi = String.valueOf(i + 1);
            for (int k = 1; k <= target; k++) {
                if (k < costi)
                    dp[i][k] = dp[i - 1][k];
                else if (k == costi)
                    dp[i][k] = strMax(numi, dp[i - 1][k]);
                else
                    dp[i][k] = "".equals(dp[i][k - costi]) ? dp[i - 1][k]
                            : strMax(dp[i - 1][k], numi + dp[i][k - costi]);
            }
        }
        return "".equals(dp[itemLen - 1][target]) ? "0" : dp[itemLen - 1][target];
    }

    public String strMax(String a, String b) {
        if (a == null || "".equals(a))
            return b;
        if (b == null || "".equals(b))
            return a;
        int aLen = a.length(), bLen = b.length();
        if (aLen != bLen)
            return aLen > bLen ? a : b;
        for (int i = 0; i < aLen; i++) {
            int aNum = a.charAt(i), bNum = b.charAt(i);
            if (aNum != bNum)
                return aNum > bNum ? a : b;
        }
        return a;
    }

    public static void main(String[] args) {
        _35_largestNum_1449 solution = new _35_largestNum_1449();
        int[] costs = { 70, 84, 55, 63, 74, 44, 27, 76, 34 };
        int target = 659;
        String largestNumber = solution.largestNumber(costs, target);
        System.out.println(largestNumber);
    }
}
