package leetcode.Labuladong.G_dynamicPlanning.C_bag;

public class B_maxForm_474 {

    public int findMaxForm(String[] strs, int m, int n) {
        return 0;
    }

    public int[] Str01Counts(String str) {
        int[] str01 = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') str01[0]++;
            else str01[1]++;
        }
        return str01;
    }

    
    public int OfficalFindMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int mi, ni;
        // 遍历物品
        for (String stri : strs) {
            int[] striMN = Str01Counts(stri);
            mi = striMN[0]; ni = striMN[1];
            if(mi>m||ni>n) continue;
            // 遍历重量，相当于一维dp
            // 正序，当前轮 当前项 更新后的结果影响到后续的项；
            // 必须倒序以确保当前项用的是上一轮的结果
            for (int i = m; i >= mi; i--) {
                for (int j = n; j >= ni; j--) {
                    // 不装入背包；装入背包
                    dp[i][j] = Math.max(dp[i][j], dp[i - mi][j - ni] + 1);
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        B_maxForm_474 solution = new B_maxForm_474();
        String[] strs = { "10", "0001", "111001", "1", "0" };
        int m = 5, n = 3;
        System.out.println(solution.OfficalFindMaxForm(strs, m, n));
    }
}
