package leetcode.Labuladong;

class Solution {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int row, col;
    private boolean[][] visited;

    public int numEnclaves(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];
        // 左右边界
        for (int i = 0; i < row; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, col - 1);
        }
        // 上下边界
        for (int j = 1; j < col - 1; j++) {
            dfs(grid, 0, j);
            dfs(grid, row - 1, j);
        }
        int enclaves = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    public void dfs(int[][] grid, int rowi, int coli) {
        if (rowi < 0 || rowi >= row || coli < 0 || coli >= col || grid[rowi][coli] == 0 || visited[rowi][coli]) {
            return;
        }
        visited[rowi][coli] = true;
        for (int[] dir : dirs) {
            dfs(grid, rowi + dir[0], coli + dir[1]);
        }
    }
}