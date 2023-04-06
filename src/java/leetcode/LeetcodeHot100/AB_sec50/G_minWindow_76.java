package leetcode.LeetcodeHot100.AB_sec50;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class G_minWindow_76 {

    public static void main(String[] args) {
        G_minWindow_76 ans = new G_minWindow_76();
        String data = "q", patt = "p";
        System.out.println(ans.minWindow(data, patt));
    }

    public String minWindow(String d, String p) {
        String minAns = d+p;
        char[] data = d.toCharArray(), patt = p.toCharArray();
        int left = 0, right = 0, dataLen = d.length();
        if (dataLen < p.length())
            return "";
        Map<Character, Integer> pMap = new HashMap<>(), dMap = new HashMap<>();
        for (char c : patt)
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        Set<Character> pKeys = pMap.keySet();
        while (left <= right && right < dataLen) {
            char rChar = data[right++];
            if (pKeys.contains(rChar))
                dMap.put(rChar, dMap.getOrDefault(rChar, 0) + 1);
            while (canShrink(pMap, dMap, pKeys)) {
                if (minAns.length() > right - left)
                    minAns = d.substring(left, right);
                char lChar = data[left++];
                if (pKeys.contains(lChar))
                    dMap.put(lChar, dMap.get(lChar) - 1);
            }
        }
        return minAns.equals(d+p) ? "" : minAns;
    }

    public boolean canShrink(Map<Character, Integer> pMap, Map<Character, Integer> dMap, Set<Character> pKeys) {
        for (Character c : pKeys) {
            if (!dMap.containsKey(c) || pMap.get(c) > dMap.get(c))
                return false;
        }
        return true;
    }

}
