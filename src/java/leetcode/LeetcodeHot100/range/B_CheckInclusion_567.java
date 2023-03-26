package leetcode.LeetcodeHot100.range;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B_CheckInclusion_567 {

    public static void main(String[] args) {
        B_CheckInclusion_567 solution = new B_CheckInclusion_567();
        String s1 = "aade";
        String s2 = "acadea";
        System.out.println(solution.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String patt, String data) {
        Map<Character, Integer> pattFreq = new HashMap<>();
        int pattLen = patt.length(), pattFreqLen = 0;
        for (Character c : patt.toCharArray()) {
            int precCount = pattFreq.getOrDefault(c, 0);
            pattFreqLen += (precCount == 0) ? 0 : 1;
            pattFreq.put(c, precCount + 1);
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
                return true;
        }
        return false;
    }

    /**
     * @description 102/107 思路不对
     * @see https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-7k7u/
     */
    public static boolean MineCheckInclusion(String s1, String s2) {
        int s1Len = s1.length();
        Map<Character, Integer> s1Map = new HashMap<>(s1Len);
        Set<Character> s1Set = new HashSet<>();
        for (int i = 0; i < s1Len; i++) {
            char chari = s1.charAt(i);
            if (s1Map.containsKey(chari)) {
                s1Map.put(chari, s1Map.get(chari) + 1);
            } else {
                s1Set.add(chari);
                s1Map.put(chari, 1);
            }
        }
        Map<Character, Integer> s2SubStrMap = new HashMap<>(s1Len);
        int left = 0, right = 1;
        while (right <= s2.length() && left < s2.length()) {
            char[] subStrChars = s2.substring(left, right).toCharArray();
            System.out.println(String.valueOf(left) + "," + String.valueOf(right) + ": " + s2.substring(left, right));
            if (subStrChars.length < s1Len) {
                right++;
                continue;
            }
            s1Set.forEach(chari -> s2SubStrMap.put(chari, 0));
            for (char chari : subStrChars) {
                if (s1Map.containsKey(chari)) {
                    s2SubStrMap.put(chari, s2SubStrMap.get(chari) + 1);
                } else {
                    left++;
                    continue;
                }
            }
            int sameCharLen = 0;
            for (char chari : s1Set) {
                if (s2SubStrMap.containsKey(chari)) {
                    if (s1Map.get(chari) == s2SubStrMap.get(chari))
                        sameCharLen++;
                    else if (s1Map.get(chari) > s2SubStrMap.get(chari))
                        right++;
                    else
                        left++;
                }
            }
            if (sameCharLen == s1Set.size())
                return true;

        }
        return false;
    }

    public static boolean checkInclusion1(String s1, String s2) {
        int[] tempFreq = new int[26];
        int tempLen = s1.length(), tempCount = 0;
        for (char i : s1.toCharArray()) {
            tempFreq[GetCharIndex(i)]++;
        }
        for (int freq : tempFreq) {
            if (freq != 0)
                tempCount++;
        }
        int[] targetFreq = new int[26];
        char[] targetArray = s2.toCharArray();
        int left = 0, right = 0, targetLen = targetArray.length, targetCount = 0;
        while (right <= targetLen) {
            while (right > left && targetCount == tempCount) {
                if (right - left == tempLen)
                    return true;
                if (tempFreq[GetCharIndex(targetArray[left])] != 0) {
                    if (targetFreq[GetCharIndex(targetArray[left])] == tempFreq[GetCharIndex(targetArray[left])])
                        targetCount--;
                    targetFreq[GetCharIndex(targetArray[left])]--;
                }
                left++;
            }
            if (right < targetLen && tempFreq[GetCharIndex(targetArray[right])] != 0) {
                if (targetFreq[GetCharIndex(targetArray[right])] + 1 == tempFreq[GetCharIndex(targetArray[right])])
                    targetCount++;
                targetFreq[GetCharIndex(targetArray[right])]++;
            }
            right++;
        }
        return false;
    }

    public static int GetCharIndex(char i) {
        return i - 'a';
    }

}
