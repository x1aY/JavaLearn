package exams.history.tencentMusic_0323;
import java.util.HashMap;
import java.util.Map;

public class Second {

    public static void main(String[] args) {
        Second ans = new Second();
        String str = "ababbbb";
        int k = 2;
        System.out.println(ans.getMaxValue(str, k));
    }

    Map<Character, String> char2Str;

    String[][] strInfo;

    int[][] strVals;

    char[] chars;

    int ans = Integer.MAX_VALUE;

    public int getMaxValue(String str, int k) {
        int len = str.length();
        chars = str.toCharArray();
        char2Str = new HashMap<>();
        strInfo = new String[len][len];
        strVals = new int[len][len];
        for (int i = 0; i < len; i++) {
            char2Str.put(chars[i], String.valueOf(chars[i]));
            strInfo[i][i] = char2Str.get(chars[i]);
        }
        backtrack(0, len - 1, k - 1, 0);
        return ans;
    }

    public String uniqueStr(int start, int end) {
        if (strInfo[start][end] == null) {
            if (strInfo[start + 1][end] != null) {
                strInfo[start][end] = strInfo[start + 1][end];
                String startChar = char2Str.get(chars[start]);
                if (!strInfo[start][end].contains(startChar))
                    strInfo[start][end] = startChar + strInfo[start][end];
            } else {
                strInfo[start][end - 1] = uniqueStr(start, end - 1);
                strInfo[start][end] = strInfo[start][end - 1];
                String endChar = char2Str.get(chars[end]);
                if (!strInfo[start][end].contains(endChar))
                    strInfo[start][end] = strInfo[start][end] + endChar;
            }
        }
        return strInfo[start][end];
    }

    public void backtrack(int start, int end, int k, int preMax) {
        if (start > end)
            return;
        if (k == 0) {
            if (strVals[start][end] == 0)
                strVals[start][end] = uniqueStr(start, end).length() * (end - start + 1);
            int currVal = strVals[start][end];
            ans = Math.min(ans, Math.max(preMax, currVal));
            return;
        }
        for (int curIdx = start; curIdx <= end; curIdx++) {
            if (strVals[start][curIdx] == 0)
                strVals[start][curIdx] = uniqueStr(start, curIdx).length() * (curIdx - start + 1);
            int cutVal = strVals[start][curIdx];
            backtrack(curIdx + 1, end, k - 1, Math.max(cutVal, preMax));
        }
    }

}
