package exams.history.meiTuan_0325;

public class Sec {

    public static void main(String[] args) {
        int[] list = new int[] { 3, 1, 2, 7, 10, 2, 4 };
        maxSeq(list, 7);
        // try (Scanner sc = new Scanner(System.in)) {
        // int len = sc.nextInt();
        // int[] list = new int[len];
        // for (int i = 0; i < len; i++)
        // list[i] = sc.nextInt();
        // System.out.println(maxSeq(list, len));
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }

    public static int maxSeq(int[] list, int len) {
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = list[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][1];
            if (i - 2 >= 0)
                dp[i][0] = Math.max(dp[i][0], dp[i - 2][1]);
            if (i - 3 >= 0)
                dp[i][0] = Math.max(dp[i][0], dp[i - 3][1]);
            
            dp[i][1] = list[i];
            if (i - 3 >= 0)
                dp[i][1] += Math.max(dp[i - 3][0], dp[i - 3][1]);

            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }

}
