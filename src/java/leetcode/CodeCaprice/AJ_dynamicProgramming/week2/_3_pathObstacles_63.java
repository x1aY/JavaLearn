package leetcode.CodeCaprice.AJ_dynamicProgramming.week2;

public class _3_pathObstacles_63 {
    public int uniquePathsWithObstacles(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0, isFlat = 1; i < row; i++) {
            if (grid[i][0] == 1)
                isFlat = 0;
            dp[i][0] = isFlat == 1 ? 1 : 0;
        }
        for (int i = 0, isFlat = 1; i < col; i++) {
            if (grid[0][i] == 1)
                isFlat = 0;
            dp[0][i] = isFlat == 1 ? 1 : 0;
        }
        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++)
                dp[i][j] = grid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];

        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        _3_pathObstacles_63 solution = new _3_pathObstacles_63();
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
