package leetcode.Labuladong.A_DataStructure.D_slideWindow;

import java.util.HashMap;
import java.util.Map;

public class AE_MinWindow_76 {

    public static void main(String[] args) {
        AE_MinWindow_76 solution = new AE_MinWindow_76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }

    public String minWindow(String data, String patt) {
        if (data.length() < patt.length()) return "";
        Map<Character, Integer> pattFreq = new HashMap<>();
        int pattFreqLen = 0;
        for (Character c : patt.toCharArray()) {
            int cFreq = pattFreq.getOrDefault(c, 0);
            pattFreqLen += (cFreq == 0) ? 1 : 0;
            pattFreq.put(c, cFreq + 1);
        }

        char[] chars = data.toCharArray();
        Map<Character, Integer> dataFreq = new HashMap<>();
        int len = data.length(), dataFreqLen = 0;
        int left = 0, right = 0, minLeft = 0, minRight = Integer.MAX_VALUE;
        while (right < len) {
            char rChar = chars[right++];
            // 用扩张前的数据辅助判断
            int rCharFreq = dataFreq.getOrDefault(rChar, 0);
            if (pattFreq.containsKey(rChar)) {
                // 子序列，不需要减
                if (rCharFreq + 1 == pattFreq.get(rChar))
                    dataFreqLen++;
                // else if (rCharFreq == pattFreq.get(rChar)) dataFreqLen--;
            }
            dataFreq.put(rChar, rCharFreq + 1);
            // 优化可行解，使其最短
            while (dataFreqLen == pattFreqLen) {
                if (minRight - minLeft > right - left) {
                    minLeft = left;
                    minRight = right;
                }
                char lChar = chars[left++];
                int lCharFreq = dataFreq.get(lChar);
                if (pattFreq.containsKey(lChar)) {
                    if (lCharFreq == pattFreq.get(lChar))
                        dataFreqLen--;
                    // else if (lCharFreq == pattFreq.get(lChar) + 1) dataFreqLen++;
                }
                dataFreq.put(lChar, lCharFreq - 1);
            }
        }
        return minRight == Integer.MAX_VALUE ? "" : data.substring(minLeft, minRight);
    }

    public static String minWindow1(String s, String t) {
        int textLen = s.length();
        char[] textArray = s.toCharArray(), pattArray = t.toCharArray();
        int[] textFreq = new int[60], pattFreq = new int[60];
        for (char pattChar : pattArray)
            pattFreq[charIndex(pattChar)]++;
        int pattCount = 0;
        for (int pattFreqi : pattFreq) {
            if (pattFreqi > 0)
                pattCount++;
        }

        int minLeft = 0, minRight = textLen + 1;
        int left = 0, right = 0;
        int textCount = 0;
        while (right <= textLen) {
            while (pattCount == textCount) {
                if (minRight - minLeft > right - left) {
                    minLeft = left;
                    minRight = right;
                }
                if (pattFreq[charIndex(textArray[left])] > 0) {
                    int textFreqPreLeft = textFreq[charIndex(textArray[left])]--;
                    if (textFreqPreLeft == pattFreq[charIndex(textArray[left])])
                        textCount--;
                }
                left++;
            }
            if (right < textLen && pattFreq[charIndex(textArray[right])] > 0) {
                int textFreqPreRight = textFreq[charIndex(textArray[right])]++;
                if (textFreqPreRight == pattFreq[charIndex(textArray[right])] - 1)
                    textCount++;
            }
            right++;
        }
        if (minRight == textLen + 1)
            return "";
        return s.substring(minLeft, minRight);
    }

    public static int charIndex(char chari) {
        return chari - 'A';
    }

}
