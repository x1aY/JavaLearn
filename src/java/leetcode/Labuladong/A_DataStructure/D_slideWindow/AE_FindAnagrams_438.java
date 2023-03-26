package leetcode.Labuladong.A_DataStructure.D_slideWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AE_FindAnagrams_438 {

    public static void main(String[] args) {
        AE_FindAnagrams_438 solution = new AE_FindAnagrams_438();
        String s = "cbaebabacd";
        String p = "abc";
        solution.findAnagrams(s, p);
    }

    public List<Integer> findAnagrams(String data, String patt) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> pattFreq = new HashMap<>();
        int pattLen = patt.length(), pattFreqLen = 0;
        for (Character c : patt.toCharArray()) {
            int cFreq = pattFreq.getOrDefault(c, 0);
            pattFreqLen += (cFreq == 0) ? 1 : 0;
            pattFreq.put(c, cFreq + 1);
        }
        Map<Character, Integer> dataFreq = new HashMap<>();
        char[] chars = data.toCharArray();
        int len = data.length(), dataFreqLen = 0, left = 0, right = 0;
        while (right < len) {
            char rChar = chars[right++];
            // 用扩张前的数据辅助判断
            int rCharFreq = dataFreq.getOrDefault(rChar, 0);
            if (pattFreq.containsKey(rChar)) {
                if (rCharFreq == pattFreq.get(rChar))
                    dataFreqLen--;
                else if (rCharFreq + 1 == pattFreq.get(rChar))
                    dataFreqLen++;
            }
            // 必须在最后更新，不然前面的判断会造成影响
            dataFreq.put(rChar, rCharFreq + 1);
            while (right - left > pattLen) {
                char lChar = chars[left++];
                int lCharFreq = dataFreq.get(lChar);
                if (pattFreq.containsKey(lChar)) {
                    if (lCharFreq == pattFreq.get(lChar))
                        dataFreqLen--;
                    else if (lCharFreq == pattFreq.get(lChar) + 1)
                        dataFreqLen++;
                }
                dataFreq.put(lChar, lCharFreq - 1);
            }
            if (pattFreqLen == dataFreqLen)
                res.add(left);
        }
        return res;
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> indexs = new ArrayList<>();
        char[] textArray = s.toCharArray();
        char[] pattArray = p.toCharArray();

        int[] textFreq = new int[26];
        int[] pattFreq = new int[26];

        int textLen = textArray.length;
        int pattLen = pattArray.length;

        if (textLen < pattLen) {
            return indexs;
        }

        for (int i = 0; i < pattLen; i++) {
            pattFreq[getCharIndex(pattArray[i])]++;
        }

        int left = 0, right = 0;
        // = 是为了最后一个字符
        while (right <= textLen) {
            // 对左边界的收缩
            while (right - left >= pattLen) {
                if (right - left == pattLen && Arrays.equals(textFreq, pattFreq))
                    indexs.add(left);
                if (pattFreq[getCharIndex(textArray[left])] > 0)
                    textFreq[getCharIndex(textArray[left])]--;
                left++;
            }
            // right 负责扩张
            // right < textLen 是为了最后一次循环，此时right=textLen
            if (right < textLen && pattFreq[getCharIndex(textArray[right])] > 0)
                textFreq[getCharIndex(textArray[right])]++;
            right++;
        }
        System.out.println(Arrays.toString(indexs.stream().mapToInt(
            idx-> Objects.isNull(idx)?0:idx.intValue()).toArray()));
        return indexs;
    }

    public static int getCharIndex(char chari) {
        return chari - 'a';
    }

}
