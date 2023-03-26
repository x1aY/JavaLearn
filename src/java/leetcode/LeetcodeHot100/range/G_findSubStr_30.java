package leetcode.LeetcodeHot100.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class G_findSubStr_30 {

    public static void main(String[] args) {
        G_findSubStr_30 solution = new G_findSubStr_30();
        String[] words = { "a" };
        String s = "a";
        solution.findSubstring(s, words);
    }

    public List<Integer> findSubstring(String data, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordsFreq = new HashMap<>(), dataFreq = new HashMap<>();
        for (String word : words) wordsFreq.put(word, wordsFreq.getOrDefault(word, 0) + 1);
        int wordLen = words[0].length(), windowLen = words.length * wordLen;
        // 若从0-dataLen, 中间太多重复
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            while (right + wordLen <= data.length()) {
                String word = data.substring(right, right + wordLen);
                right += wordLen;
                // 要求是子串，直接清空
                if (!wordsFreq.containsKey(word)) {
                    left = right;
                    dataFreq.clear();
                } else {
                    dataFreq.put(word, dataFreq.getOrDefault(word, 0) + 1);
                    // 保持在windowLen
                    if (right - left >= windowLen) {
                        if (wordsFreq.equals(dataFreq))
                            res.add(left);
                        word = data.substring(left, left + wordLen);
                        left += wordLen;
                        dataFreq.put(word, dataFreq.getOrDefault(word, 0) - 1);
                    }
                }
            }
            dataFreq.clear();
        }
        return res;
    }

    public String str2hash(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

}
