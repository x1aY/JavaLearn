package exams.history.meiTuan_0318;


public class DPStore {

    public static void main(String[] args) {
        DPStore solution = new DPStore();
        int items = 5, money = 100, discounts = 2;
        int[][] prices = new int[][] { { 10, 5 }, { 50, 30 }, { 40, 30 }, { 20, 10 } };
        System.out.println(solution.costs(items, prices, money, discounts));
    }

    public int[] costs(int items, int[][] prices, int money, int n_discount) {
        int[][][] dp = new int[items][money][n_discount];
        for (int j = 0; j < money; j++) {
            for (int k = 0; k < n_discount; k++) {
                dp[0][j][k] = 1;
            }
        }
        
        for (int i = 1; i < items; i++) {
            for (int j = 0; j < money; j++) {
                for (int k = 0; k < n_discount; k++) {
                    dp[i][j][k] = Math.max(dp[i - 1][j][k],
                            Math.max(dp[i - 1][j - prices[i][0]][k],
                                    dp[i - 1][j - prices[i][1]][k - 1]));
                }
            }
        }

        return new int[] { 1, 2 };
    }

}
