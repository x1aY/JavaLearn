package leetcode.LeetcodeHot100.AB_sec50;

public class E_minDistance_72 {

    public static void main(String[] args) {
        E_minDistance_72 ans = new E_minDistance_72();
        ans.minDistance("intention", "execution");
    }

    /**
     * 对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：
        以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
        (1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
        (2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
        (3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
     */
    public int minDistance(String s1, String s2) {
        int fstLen = s1.length(), secLen = s2.length();
        if (fstLen == 0 || secLen == 0) return fstLen == 0 ? secLen : fstLen;
        char[] fst = s1.toCharArray(), sec = s2.toCharArray();
        int[][] dp = new int[fstLen][secLen];
        dp[0][0] = fst[0] == sec[0] ? 0 : 1;
        for (int i = 1; i < fstLen; i++)
            dp[i][0] = fst[i] == sec[0] ? i : dp[i - 1][0] + 1;
        for (int i = 1; i < secLen; i++)
            dp[0][i] = sec[i] == fst[0] ? i : dp[0][i - 1] + 1;
        for (int i = 1; i < fstLen; i++) {
            for (int j = 1; j < secLen; j++) {
                if (fst[i] == sec[j])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[fstLen - 1][secLen - 1];
    }

}
