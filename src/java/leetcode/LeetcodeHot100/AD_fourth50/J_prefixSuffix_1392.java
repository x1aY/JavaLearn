package leetcode.LeetcodeHot100.AD_fourth50;

import java.util.Arrays;

public class J_prefixSuffix_1392 {

    // Rabin-Karp 字符串编码
    // https://leetcode.cn/problems/longest-happy-prefix/solution/zui-chang-kuai-le-qian-zhui-by-leetcode-solution/
    // KMP
    // https://programmercarl.com/0459.%E9%87%8D%E5%A4%8D%E7%9A%84%E5%AD%90%E5%AD%97%E7%AC%A6%E4%B8%B2.html#kmp
    class Solution {
        public String longestPrefix(String s) {
            int n = s.length();
            long prefix = 0, suffix = 0;
            long base = 31, mod = 1000000007, mul = 1;
            int happy = 0;
            for (int i = 1; i < n; ++i) {
                prefix = (prefix * base + (s.charAt(i - 1) - 'a')) % mod;
                suffix = (suffix + (s.charAt(n - i) - 'a') * mul) % mod;
                if (prefix == suffix) {
                    happy = i;
                }
                mul = mul * base % mod;
            }
            return s.substring(0, happy);
        }
    }

    class Solution1 {
        public String longestPrefix(String s) {
            int n = s.length();
            int[] fail = new int[n];
            Arrays.fill(fail, -1);
            for (int i = 1; i < n; ++i) {
                int j = fail[i - 1];
                while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                    j = fail[j];
                }
                if (s.charAt(j + 1) == s.charAt(i)) {
                    fail[i] = j + 1;
                }
            }
            return s.substring(0, fail[n - 1] + 1);
        }
    }

}
