package leetcode.LeetcodeHot100.AA_fst50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AT_groupAnagrams_49 {

    public static void main(String[] args) {
        AT_groupAnagrams_49 solution = new AT_groupAnagrams_49();
        solution.groupAnagrams(
                new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
    }

    // 排序作为key，更快
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> strHash2ansIdx = new HashMap<>();
        int maxAnsIdx = 0;
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String strHash = String.valueOf(strChars);
            if (strHash2ansIdx.containsKey(strHash)) {
                ans.get(strHash2ansIdx.get(strHash)).add(str);
            } else {
                strHash2ansIdx.put(strHash, maxAnsIdx);
                ans.add(new ArrayList<>());
                ans.get(maxAnsIdx++).add(str);
            }
        }
        return ans;
    }

    // char加count组合成str作为key
    class solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            Map<String, Integer> strHash2ansIdx = new HashMap<>();
            int maxAnsIdx = 0;
            for (String str : strs) {
                int[] counts = countStr(str);
                String strHash = str2hash(counts);
                if (strHash2ansIdx.containsKey(strHash)) {
                    ans.get(strHash2ansIdx.get(strHash)).add(str);
                } else {
                    strHash2ansIdx.put(strHash, maxAnsIdx);
                    ans.add(new ArrayList<>());
                    ans.get(maxAnsIdx++).add(str);
                }
            }
            return ans;
        }

        public int[] countStr(String str) {
            int[] counts = new int['z' - 'A' + 1];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'A']++;
            }
            return counts;
        }

        public String str2hash(int[] counts) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('A' + i));
                    sb.append(counts[i]);
                }
            }
            return sb.toString();
        }
    }

}
