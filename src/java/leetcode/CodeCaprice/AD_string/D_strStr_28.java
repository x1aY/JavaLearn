package leetcode.CodeCaprice.AD_string;

public class D_strStr_28 {

    public int strStr(String haystack, String needle) {
        char[] strList = haystack.toCharArray(), pattList = needle.toCharArray();
        int strLen = strList.length, pattLen = pattList.length;
        int[] next = genNext(pattList, pattLen);
        for (int i = 0, j = 0; i < strLen; i++) {
            while (j > 0 && strList[i] != pattList[j])
                j = next[j - 1];
            if (strList[i] == pattList[j])
                j++;
            if (j == pattLen)
                return i - j + 1;
        }
        return -1;
    }

    public int[] genNext(char[] regex, int length) {
        int[] next = new int[length];
        next[0] = 0;
        for (int j = 0, i = 1; i < length; i++) {
            while (j > 0 && regex[i] != regex[j])
                j = next[j - 1];
            if (regex[i] == regex[j])
                j++;
            next[i] = j;
        }

        return next;
    }

    public static void main(String[] args) {
        D_strStr_28 solution = new D_strStr_28();
        String haystack = "aabaabaaf";
        String needle = "aabaaf";
        System.out.println(solution.strStr(haystack, needle));
    }

}