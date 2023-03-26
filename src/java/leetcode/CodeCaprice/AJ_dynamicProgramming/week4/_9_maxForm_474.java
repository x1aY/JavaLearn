package leetcode.CodeCaprice.AJ_dynamicProgramming.week4;

public class _9_maxForm_474 {

    public int[] str2MN(String str) {
        int strM = 0, strN = 0;
        for (char c : str.toCharArray()) {
            if (c == '0')
                strM++;
            else
                strN++;
        }
        return new int[] { strM, strN };
    }

    public int findMaxForm(String[] strs, int m, int n) {
        return 0;
    }

    public static void main(String[] args) {
        _9_maxForm_474 solution = new _9_maxForm_474();
        String[] strs = { "10", "0001", "111001", "1", "0" };
        int m = 5, n = 3;
        solution.findMaxForm(strs, m, n);
    }
}
