package leetcode.CodeCaprice.AJ_dynamicProgramming.week5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _14_wordBreak_139 {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int strLen = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[strLen];
        Arrays.fill(dp, false);
        for (int i = 0; i < dp.length; i++)
            dp[i] = wordSet.contains(s.substring(0, i + 1));
        for (int i = 1; i < strLen; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] == false)
                    dp[i] = dp[j] && wordSet.contains(s.substring(j + 1, i + 1));
            }
        }
        return dp[strLen - 1];
    }

    public static void main(String[] args) {
        _14_wordBreak_139 solution = new _14_wordBreak_139();
        List<String> wordDict = Arrays.asList("aaaa", "aaa");
        String s = "aaaaaaa";
        solution.wordBreak(s, wordDict);
    }
}
