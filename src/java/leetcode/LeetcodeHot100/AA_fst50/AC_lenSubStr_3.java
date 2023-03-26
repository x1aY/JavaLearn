package leetcode.LeetcodeHot100.AA_fst50;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AC_lenSubStr_3 {
    public static void main(String[] args) {
        AC_lenSubStr_3 solution = new AC_lenSubStr_3();
        String s = "pwwkew";
        solution.lengthOfLongestSubstring(s);
    }

    public static int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        Map<Character, Integer> charFreq = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < len) {
            char rChar = chars[right++];
            charFreq.put(rChar, charFreq.getOrDefault(rChar, 0) + 1);
            while (charFreq.get(rChar) > 1) {
                char lChar = chars[left++];
                charFreq.put(lChar, charFreq.get(lChar) - 1);
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length, maxLen = 0;
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int curr = 1;
            charSet.add(chars[i]);
            for (int j = i - 1; j >= 0; j--) {
                if (charSet.contains(chars[j]))
                    break;
                else {
                    curr++;
                    charSet.add(chars[j]);
                }
            }
            charSet.clear();
            maxLen = Math.max(maxLen, curr);
        }
        return maxLen;
    }
}
