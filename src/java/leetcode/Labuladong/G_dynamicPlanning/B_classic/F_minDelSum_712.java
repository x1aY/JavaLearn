package leetcode.Labuladong.G_dynamicPlanning.B_classic;

import java.util.Arrays;

public class F_minDelSum_712 {

    char[] arrayL, arrayR;
    int[] arrayIntL, arrayIntR;
    int LLen, RLen;
    int[][] mem;

    public int minimumDeleteSum(String s1, String s2) {
        arrayL = s1.toCharArray();
        arrayR = s2.toCharArray();
        LLen = arrayL.length;
        RLen = arrayR.length;

        mem = new int[LLen][RLen];
        for (int[] memi : mem) Arrays.fill(memi, -1);
        return minDelDp(LLen - 1, RLen - 1);
    }

    private int minDelDp(int LIndex, int RIndex) {
        int leftSum = 0;
        if (LIndex == -1 && RIndex == -1) return 0;
        // i <= RIndex !!! 注意边界
        else if (LIndex == -1) {
            for (int i = 0; i <= RIndex; i++) leftSum += arrayR[i];
            return leftSum;
        } else if (RIndex == -1) {
            for (int i = 0; i <= LIndex; i++) leftSum += arrayL[i];
            return leftSum;
        }
        if (mem[LIndex][RIndex] != -1) return mem[LIndex][RIndex];

        if (arrayL[LIndex] == arrayR[RIndex]) return minDelDp(LIndex - 1, RIndex - 1);

        mem[LIndex][RIndex] = Math.min(
            minDelDp(LIndex, RIndex - 1) + arrayR[RIndex],
            minDelDp(LIndex - 1, RIndex) + arrayL[LIndex]);

        System.out.println(LIndex + "," + RIndex + "," + mem[LIndex][RIndex]);

        return mem[LIndex][RIndex];
    }

    public static void main(String[] args) {
        F_minDelSum_712 solution = new F_minDelSum_712();
        String s1 = "sea", s2 = "eat";

        System.out.println(solution.minimumDeleteSum(s1, s2));
    }
}
