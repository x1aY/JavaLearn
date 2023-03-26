package leetcode.LeetcodeHot100.AA_fst50;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AI_letterCombine_17 {

    public static void main(String[] args) {
        AI_letterCombine_17 solution = new AI_letterCombine_17();
        String digits = "234";
        solution.letterCombinations(digits);
    }

    // 或者用队列
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if (digits.length() == 0)
            return ans;
        Map<Character, String> num2Strs = Num2Strs();
        for (Character digit : digits.toCharArray()) {
            String strs = num2Strs.get(digit);
            int ansLen = ans.size(), strsLen = strs.length();
            if (ansLen == 0)
                for (int i = 0; i < strsLen; i++)
                    ans.add(strs.substring(i, i + 1));
            else {
                // 删除list中的元素，需要倒序
                for (int i = ansLen - 1; i >= 0; i--) {
                    String currStr = ans.remove(i);
                    for (int j = 0; j < strsLen; j++)
                        ans.add(currStr + strs.substring(j, j + 1));
                }
            }
        }
        return ans;
    }

    public Map<Character, String> Num2Strs() {
        Map<Character, String> num2Str = new HashMap<>();
        num2Str.put('2', "abc");
        num2Str.put('3', "def");
        num2Str.put('4', "ghi");
        num2Str.put('5', "jkl");
        num2Str.put('6', "mno");
        num2Str.put('7', "pqrs");
        num2Str.put('8', "tuv");
        num2Str.put('9', "wxyz");
        return num2Str;
    }

}
