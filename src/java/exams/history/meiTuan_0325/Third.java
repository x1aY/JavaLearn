package exams.history.meiTuan_0325;

import java.util.*;

public class Third {

    public static void main(String[] args) {
        int iLen = 5, qLen = 5;
        int[] items = new int[] { 2, 3, 3, 4, 5 },
                querys = new int[] { 3, 9, 13, 22, 100 };
        int pre = 0;
        for (int i = 0; i < iLen; i++) {
            System.out.print(String.valueOf(items[i] * items[i] + pre) + ", ");
            pre += items[i] * items[i];
        }
        System.out.println();
        int[] ans = answerQuery(iLen, items, qLen, querys);
        for (int i = 0; i < qLen; i++) {
            System.out.print(String.valueOf(ans[i]) + ", ");
        }


        
        // try (Scanner sc = new Scanner(System.in)) {
        // int iLen = sc.nextInt();
        // int qLen = sc.nextInt();
        // int[] items = new int[iLen], querys = new int[qLen];
        // for (int i = 0; i < iLen; i++)
        // items[i] = sc.nextInt();
        // for (int i = 0; i < qLen; i++)
        // querys[i] = sc.nextInt();
        // int[] answers = answerQuery(iLen, items, qLen, querys);
        // for (int answer : answers) {
        // System.out.print(answer);
        // System.out.print(" ");
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }

    public static int[] answerQuery(int iLen, int[] items, int qLen, int[] querys) {
        int[] answers = new int[qLen];
        Arrays.sort(items);
        for (int i = 0; i < qLen; i++) {
            int maxW = querys[i];
            int[] dp = new int[maxW + 1];
            int wi = items[0] * items[0];
            for (int j = wi; j <= maxW; j++)
                dp[j] = 1;

            for (int j = 1; j < iLen; j++) {
                int weightj = items[j] * items[j];
                for (int k = maxW; k > 0; k--) {
                    if (k >= weightj)
                        dp[k] = Math.max(dp[k], dp[k - weightj] + 1);
                }
            }
            answers[i] = dp[maxW];
        }
        return answers;
    }

}
