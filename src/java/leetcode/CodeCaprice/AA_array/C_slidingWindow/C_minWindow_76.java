package leetcode.CodeCaprice.AA_array.C_slidingWindow;

public class C_minWindow_76 {
    public static String minWindow(String s, String t) {
        int minLeft = 0, minRight = Integer.MAX_VALUE, tLen = 0;
        int[] tCount = new int[60];
        for (char ti : t.toCharArray())
            tCount[c2i(ti)]++;
        for (int tCi : tCount)
            if (tCi != 0)
                tLen++;

        int[] sCount = new int[60];
        int left = 0, right = 0, intOfChar, sLen = 0;

        while (right < s.length()) {
            intOfChar = c2i(s.charAt(right++));
            sCount[intOfChar]++;
            if (tCount[intOfChar] != 0) {
                if (sCount[intOfChar] == tCount[intOfChar])
                    sLen++;
            }
            while (sLen == tLen) {
                if (minRight - minLeft > right - left) {
                    minLeft = left;
                    minRight = right;
                }
                intOfChar = c2i(s.charAt(left++));
                sCount[intOfChar]--;
                if (tCount[intOfChar] != 0) {
                    if (sCount[intOfChar] + 1 == tCount[intOfChar])
                        sLen--;
                }
            }
        }
        return minRight == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight);
    }

    public static int c2i(char x) {
        return x - 'A';
    }

    public static void main(String[] args) {
        String s = "cgklivwehljxrdzpfdqsapogwvjtvbzahjnsejwnuhmomlfsrvmrnczjzjevkdvroiluthhpqtffhlzyglrvorgnalk",
                t = "mqfff";
        System.out.println(minWindow(s, t));
    }
}
