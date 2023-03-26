package leetcode.Labuladong.G_dynamicPlanning.B_classic;

import java.util.Arrays;

public class E_minDis_583 {

    char[] arrayL, arrayR;
    int LLen, RLen;
    int[][] mem;


    public int minDistance(String word1, String word2) {
        arrayL = word1.toCharArray();
        arrayR = word2.toCharArray();
        LLen = arrayL.length;
        RLen = arrayR.length;
        mem = new int[LLen][RLen];
        for (int[] memi : mem) Arrays.fill(memi, -1);
        return minDisDp(LLen - 1, RLen - 1);
    }

    private int minDisDp(int LIndex, int RIndex) {
        if (LIndex == -1 && RIndex == -1) return 0;
        else if (LIndex == -1) return RIndex + 1;
        else if (RIndex == -1) return LIndex + 1;
        if(mem[LIndex][RIndex]!=-1) return mem[LIndex][RIndex];
        if(arrayL[LIndex]==arrayR[RIndex]) return minDisDp(LIndex-1, RIndex-1);
        // 删除一步，最后要加一
        mem[LIndex][RIndex] = Math.min(minDisDp(LIndex, RIndex-1),minDisDp(LIndex-1, RIndex)) + 1;
        System.out.println(LIndex+","+RIndex+","+mem[LIndex][RIndex]);
        return mem[LIndex][RIndex];
    }

    public static void main(String[] args) {
        E_minDis_583 solution = new E_minDis_583();
        String word1 = "sea", word2 = "eat";
        System.out.println(solution.minDistance(word1, word2));
    }
}
