package leetcode.Labuladong.G_dynamicPlanning.B_classic;

import java.util.Arrays;
// import java.util.Comparator;

public class B_maxEnvelopes_354 {
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;

        int[][] envMinMaxIndex = new int[len][2];
        int[] maxCounts = new int[len];
        for (int i = 0; i < len; i++) {
            maxCounts[i] = 1;
            envMinMaxIndex[i][0] = i;
            envMinMaxIndex[i][1] = i;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (canPutIn(envelopes[i], envelopes[envMinMaxIndex[j][0]]) &&
                        maxCounts[i] < maxCounts[j] + 1) {
                    maxCounts[i] = maxCounts[j] + 1;
                    envMinMaxIndex[i][0] = i;
                    envMinMaxIndex[i][1] = envMinMaxIndex[j][1];
                } else if (canPutIn(envelopes[envMinMaxIndex[j][1]], envelopes[i]) &&
                        maxCounts[i] < maxCounts[j] + 1) {
                    maxCounts[i] = maxCounts[j] + 1;
                    envMinMaxIndex[i][0] = envMinMaxIndex[j][0];
                    envMinMaxIndex[i][1] = i;
                }
            }
        }

        int maxCount = maxCounts[0];
        for (int i : maxCounts)
            if (maxCount < i)
                maxCount = i;
        return maxCount;
    }

    public boolean canPutIn(int[] fromEnv, int[] toEnv) {
        return fromEnv[0] < toEnv[0] && fromEnv[1] < toEnv[1];
    }

    public static void main(String[] args) {
        B_maxEnvelopes_354 solution = new B_maxEnvelopes_354();
        // int[][] envelopes = { { 30, 50 }, { 12, 2 }, { 3, 4 }, { 12, 15 } };

        // [[8,18],[4,14],[16,1],[9,11],[14,15],[12,19],[2,15],[4,4],[18,3],[20,8],[19,18],[18,2],[1,10],[12,1],[10,16],[1,1],[3,19]]
        // 5

        int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        System.out.println(solution.maxEnvelopes(envelopes));
    }
}
